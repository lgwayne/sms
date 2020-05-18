# sms

## 高校成绩管理系统（毕设初稿）

#### 用户需求分析：

- 管理员角色：主要为高校中的教务管理人员。管理员可以对所有用户的登录信息进行管理，包括对教师和学生进行管理。可以查看所有授课信息，可以对全部学科的考试成绩进行管理，同时可以对学生成绩进行分析，通过运用数理统计和标准分的计算方式对成绩多维度分析。
- 教师角色：主要为授课考核工作的执行者。教师可以对所教班级和课程的考试成绩进行查看新增和修改操作，可以对个人信息管理，可以对任教班级的学生考试成绩从班级和个人的角度分析和成绩统计。
- 学生角色：主要是教学工作的参与者。学生可以查询个人信息，可以查看在某一科目的考试成绩，可以通过对比学院、专业和班级的成绩权值，对个人的成绩进行多维度的对比分析。



#### 主要完成了以下工作：

1. 系统主要通过用Java语言和B/S架构模式，选择IntelliJ idea作为开发工具，采用SpringBoot作为系统的后台框架，用Shiro安全框架对系统进行身份验证，运用MyBatis作为程序连接MySQL数据库的持久层框架，最后在统计分析时运用了Echarts技术，综合开发了考试成绩管理系统。
2. 通过详细的需求分析和设计实现了管理员、教师和学生三种角色用户对系统中教务管理、成绩管理和分析两大功能模块的操作。
3. 在教务管理中可以实现对用户基础的新增修改和删除工作。
4. 在成绩管理中可以通过高级查询，针对不同用户角色对学生的成绩信息实现管理，完成对成绩新增删除修改查询的操作。
5. 在成绩分析模块中，不同的角色用户可以对学生成绩做数理统计和对比分析的操作，增加标准分的评定准则。运用视图化技术，通过不同图表直观展示结果。

#### 功能实现：

##### 管理员：

![admin (1).png](https://github.com/lgwayne/sms/blob/master/sms_pic/admin%20(1).png?raw=true)

![admin (2).png](https://github.com/lgwayne/sms/blob/master/sms_pic/admin%20(2).png?raw=true)

![admin (3).png](https://github.com/lgwayne/sms/blob/master/sms_pic/admin%20(3).png?raw=true)

![admin (4).png](https://github.com/lgwayne/sms/blob/master/sms_pic/admin%20(4).png?raw=true)

![admin (5).png](https://github.com/lgwayne/sms/blob/master/sms_pic/admin%20(5).png?raw=true)

##### 教师：

![teacher (1).png](https://github.com/lgwayne/sms/blob/master/sms_pic/teacher%20(1).png?raw=true)

![teacher (2).png](https://github.com/lgwayne/sms/blob/master/sms_pic/teacher%20(2).png?raw=true)

![teacher (3).png](https://github.com/lgwayne/sms/blob/master/sms_pic/teacher%20(3).png?raw=true)

##### 学生：

![student (1).png](https://github.com/lgwayne/sms/blob/master/sms_pic/student%20(1).png?raw=true)

![student (2).png](https://github.com/lgwayne/sms/blob/master/sms_pic/student%20(2).png?raw=true)
