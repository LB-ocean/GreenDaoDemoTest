package com.example.greendaodemotest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.greendaodemotest.R;
import com.example.greendaodemotest.bean.Student;
import com.example.greendaodemotest.bean.Teacher;
import com.example.greendaodemotest.util.DaoManager;
import com.example.greendaodemotest.util.MyLog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 关于GreenDao3.2.2  一对多 Demo 示例
 * 以 老师 对 多个学生 为例
 */
public class MainActivity extends AppCompatActivity
{

    @BindView(R.id.button_add_teacher)
    Button buttonAddTeacher;
    @BindView(R.id.button_add_student)
    Button buttonAddStudent;
    @BindView(R.id.button_delete_teacher)
    Button buttonDeleteTeacher;
    @BindView(R.id.button_delete_student)
    Button buttonDeleteStudent;
    @BindView(R.id.button_update)
    Button buttonUpdate;
    @BindView(R.id.button_check_teacher)
    Button buttonCheckTeacher;
    @BindView(R.id.button_check_student)
    Button buttonCheckStudent;
    @BindView(R.id.listView)
    ListView listView;
    private int j = 0;
    private List<Student> studentList;
    private List<Teacher> teacherList;
    private ArrayAdapter<Teacher> teacherArrayAdapter;
    private ArrayAdapter<Student> studentArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData()
    {
        if (studentList == null)
        {
            studentList = new ArrayList<>();
            teacherList = new ArrayList<>();
        }

    }


    @OnClick({R.id.button_add_teacher, R.id.button_add_student, R.id.button_delete_teacher, R.id.button_delete_student, R.id.button_update,R.id.button_check_teacher, R.id.button_check_student})
    public void onViewClicked(View view)
    {
        switch (view.getId())
        {
            case R.id.button_add_teacher:
                MyLog.e("MainActivity-添加老师");
                Teacher teacher = new Teacher();
                teacher.setName("王芳");
                /**
                 * 通过单例 插入 老师
                 */
                DaoManager.getInstance().getDaoSession().getTeacherDao().insert(teacher);
                break;
            case R.id.button_add_student:
                MyLog.e("MainActivity-添加学生");
                List<Teacher> teachers2 = DaoManager.getInstance().getDaoSession().getTeacherDao().loadAll();
                j++;
                Student student = new Student();
                student.setName("小明" + j + "号");
                /**
                 * 此处注意 是把 Teacher的主键ID 作为 student的外键 来用
                 */
                student.setUniqueNum(teachers2.get(0).getId());
                student.setAge((long) (15 + j));
                DaoManager.getInstance().getDaoSession().getStudentDao().insert(student);
                break;
            case R.id.button_delete_teacher:
                MyLog.e("MainActivity-删除老师");
                List<Teacher> teachers = DaoManager.getInstance().getDaoSession().getTeacherDao().loadAll();
                if (teachers != null && teachers.size() > 0)
                {
                    DaoManager.getInstance().getDaoSession().getTeacherDao().delete(teachers.get(0));
                }
                break;
            case R.id.button_delete_student:
                MyLog.e("MainActivity-删除学生");
                List<Student> students = DaoManager.getInstance().getDaoSession().getStudentDao().loadAll();
                if (students != null && students.size() > 0)
                {
                    DaoManager.getInstance().getDaoSession().getStudentDao().delete(students.get(0));
                }
                break;
            case R.id.button_update:
                List<Student> students2 = DaoManager.getInstance().getDaoSession().getStudentDao().loadAll();
                if (students2 != null && students2.size() > 0)
                {
                    for (Student studentTemp : students2)
                    {
                        studentTemp.setName(studentTemp.getName() + studentTemp.getAge());
                        DaoManager.getInstance().getDaoSession().getStudentDao().update(studentTemp);
                    }

                }

                break;
            case R.id.button_check_teacher:
                MyLog.e("MainActivity-查询老师数据");
                List<Teacher> teachers1 = DaoManager.getInstance().getDaoSession().getTeacherDao().loadAll();
                List<Student> studentListGf = teachers1.get(0).getStudentList();
                MyLog.e("MainActivity-查询老师数据对应的学生数据-studentListGf:"+studentListGf);
                teacherList.clear();
                teacherList.addAll(teachers1);
                if(teachers1!=null&&teachers1.size()>0)
                {
                    if(teacherArrayAdapter==null)
                    {
                        teacherArrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,teacherList);

                    }
                    else
                    {
                        teacherArrayAdapter.notifyDataSetChanged();
                    }
                    listView.setAdapter(teacherArrayAdapter);
                }
                else
                {
                    MyLog.e("MainActivity-查询老师数据为空");
                }
                break;
            case R.id.button_check_student:
                MyLog.e("MainActivity-查询学生数据");
                List<Student> students1 = DaoManager.getInstance().getDaoSession().getStudentDao().loadAll();
                this.studentList.clear();
                this.studentList.addAll(students1);
                if(this.studentList !=null&& this.studentList.size()>0)
                {
                    if(studentArrayAdapter==null)
                    {
                        studentArrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, this.studentList);

                    }
                    else
                    {
                        studentArrayAdapter.notifyDataSetChanged();
                    }
                    listView.setAdapter(studentArrayAdapter);
                }
                else
                {
                    MyLog.e("MainActivity-查询学生数据为空");
                }
                break;
        }
    }



}
