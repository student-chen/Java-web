#ifndef __Student_H__
//
typedef struct
{
#define __Student_H__ 
 double math;
 double cProgram;
 double english;
}Subject;
//
struct Stu
{
 char number[20];
 char name[20];
 int sex;
 Subject score;
 //名次
 int ranking;
 //平均分
 double average_score;
 struct Stu*next;
};
typedef Stu Student;
#endif 