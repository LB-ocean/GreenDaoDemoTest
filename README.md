# GreenDao3.2.2 一对多 关联
    虽然简单,此处也是遇到了不少坑,出现集合老是为null的情况,希望大家少走弯路;
## 效果图


![Image](https://github.com/LB-ocean/GreenDaoDemoTest/blob/master/picture/p1.png)


---
## 数据库插入新表

##  效果图先上:
![Image](https://github.com/LB-ocean/GreenDaoDemoTest/blob/master/picture/newTable.png)

* 1.修改 schemaVersion,原先是1;
>
    greendao {
        schemaVersion 2
        daoPackage 'com.example.greendaodemotest.db'
        targetGenDir 'src/main/java'
    }
* 2.在此类:MySqlLiteOpenHelper 中加入以下主要函数(MigrationHelper为引入一个大神写的临时存表工具类):
 >
		if (oldVersion < newVersion)
         {
             MigrationHelper.getInstance().migrate(db, StudentDao.class, TeacherDao.class);
             MyLog.e("MySqlLiteOpenHelper-----更新完成");
         }
* 3.新建一个表 例如:TestTableOne
>
		    加入以下两个字段 作为测试:
		    @Id(autoincrement = true)
		    private Long id;
		    private String testTableOnename;
* 4.在 activity 里边增加数据 显示数据,并查看之前的数据库是不是完整;贴入主要代码:
>
		    插入新表的数据
		    for (int k = 0; k < 5; k++)
		    {
		        TestTableOne tableOne = new TestTableOne();
		        tableOne.setTestTableOnename("男"+k+"号");
		        DaoManager.getInstance().getDaoSession().getTestTableOneDao().insert(tableOne);
		    }
    将新表的数据显示
>
	    List<TestTableOne> testTableOnes = DaoManager.getInstance().getDaoSession().getTestTableOneDao().loadAll();
	    if(testTableOnes!=null)
	    {
	        if(tableOneArrayAdapter==null)
	        {
	            tableOneArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, testTableOnes);
	            listView.setAdapter(tableOneArrayAdapter);
	        }
	        else
	        {
	            tableOneArrayAdapter.notifyDataSetChanged();
	        }
	    }

  后期 会增加 数据库更新等等常用的操作,一起进步;另外，还有一篇demo 也将发布,就是 MVP+rxjava2+retrofit2+lambda;希望大家多度关注;

