#include "stdio.h"
#include "stdlib.h"
#include "conio.h"
#include "Student.h"
#include "string.h"

//#pragma pack(1)

Student *buildList();
void outputAllData(Student * iStu);
void outputOneData(char key,Student * iStu);

FILE*openFile(char*fileName);
void writeBinaryFile(Student*head,FILE*fp);
Student*readBinaryFile(FILE*fp);
void sort_ranking(Student*head);

/*int main()
{
	Student *stu;

	int key;

	FILE*fp = openFile("test.bin");
	while (1)
	{
		system("cls");
		printf("1 : 新建链表\n2 :输出链表 \n3: 数据写入到文件。\n4 : 从文件中读取数据\n0.EXIT\n");
		key = getchar();
		switch(key)
		{
		case '1' :  stu = buildList();
			break;
		case '2' :	outputAllData(stu); puts("按任意键返回"); getch();
			break;
		case '3' :  writeBinaryFile(stu,fp); puts("保存成功,按任意键继续"); getch();
			break;
		case '4' :  stu = readBinaryFile(fp); puts("读取成功,按任意键继续"); getch();
			break;
		case '0' :  fclose(fp); return 0;
			break;
//		default:puts("input error"); puts(",按任意键继续"); getch();
		}

	}
	fclose(fp);
	return 0;
}*/
//以二进制打开文件，若文件不存在则创建
FILE*openFile(char*fileName)
{
	FILE*fp = NULL;

	if((fp = fopen(fileName,"a+b")) == NULL)
	{
		fprintf(stdout,"文件创建失败！");
		return NULL;
	}
	return fp;
}
//写数据到二进制文件
void writeBinaryFile(Student*head,FILE*fp)
{
	Student*p = head;

	while(p->next != NULL)
	{
		fwrite(p,sizeof(Student),1,fp);

		p = p->next;
	}
}
/*从二进制文件中读取数据,并将数据
保存在链表中，仅在打开程序时使用*/
Student*readBinaryFile(FILE*fp)
{
	if(fp == NULL)
		return NULL;

	//使文件内部指针指向开头
	rewind(fp);

	Student *head = NULL;
	Student *p1 = NULL, *p2 = NULL;
	int n = 1;

	p1 = p2 = (Student *) malloc(sizeof(Student));

//	puts("请输入学生（注：当输入学号为0时结束输入。性别 1 男。0 女）\n学号 姓名 性别 c语言 高等数学 英语");
	//赋值

	fread(p1,sizeof(Student),1,fp);
	while (!feof(fp))
	{
		if (1 == n)
		{
			head = p1;
			n++;
		}
		else
			p2->next = p1;
		p2 = p1;

		p1 = (Student *) malloc(sizeof(Student));
		fread(p1,sizeof(Student),1,fp);

	}
	p2->next = p1;
	p2 = p1;
	p2->next = NULL;
	/*
	p1 = (Student *) malloc(sizeof(Student));
	p2->next = p1;
	p1->next = NULL;
	*/

	return head;
}
Student *buildList()
{
	Student *head = NULL;
	Student *p1 = NULL, *p2 = NULL;
	int n = 1;
	puts("please input");
	//申请内存
	p1 = p2 = (Student *) malloc(sizeof(Student));
	if (p1 == NULL)
		return NULL;
	puts("请输入学生（注：当输入学号为0时结束输入。性别 1 男。0 女）\n学号 姓名 性别 c语言 高等数学 英语\n注 在这里不进行学号判断，请正确填写");
	if (scanf("%s%s%d%lf%lf%lf", p1->number, p1->name, &p1->sex, &p1->score.math, &p1->score.cProgram,&p1->score.english) != 6)
		 puts("input error");

	p1->average_score = (p1->score.math + p1->score.cProgram + p1->score.english)/3;
	p1->ranking = 0;
	while (1)					// strcmp("0", p1->number) != 0)
	{
		if (1 == n)
		{
			head = p1;
			n++;
		}
		else
			p2->next = p1;
		p2 = p1;

		p1 = (Student *) malloc(sizeof(Student));
		puts("学号 姓名 性别 c语言 高等数学 英语");
		// 判断是否退出循环
		scanf("%s", p1->number);
		if (strcmp("0", p1->number) == 0)
		{
		   p2->next = p1;
		   p2 = p1;
		   //清除输入缓冲区
		   while (getchar() != '\n')
				continue;

			break;
		}
		else
		{
			scanf("%s%d%lf%lf%lf", p1->name, &p1->sex, &p1->score.cProgram, &p1->score.math,&p1->score.english);
			p1->average_score = (p1->score.math + p1->score.cProgram + p1->score.english)/3;
			p1->ranking = 0;

		}
	}
	p2->next = NULL;
	puts("end");
	//计算名次
	sort_ranking(head);
	return head;
}

void outputAllData(Student * iStu)
{
	Student *p = iStu;
	int n = 1;
	puts("学号\t姓名\t性别\t高数\tc语言\t英语\t总分\t平均分\t名次");

    puts("=======================================================================");
	while (p->next != NULL)
	{
		printf("%-4s\t%-4s\t", p->number, p->name);
		if (p->sex == 0)
			printf("女");
		else
			printf("男");
		printf("\t%-6.2lf\t%-6.2lf\t%-6.2lf\t%-6.2lf\t%-6.2lf\t%d\n", p->score.cProgram, p->score.math, p->score.english,p->score.math + p->score.cProgram + p->score.english,p->average_score,p->ranking);

		p = p->next;
		puts("");
//		puts("=======================================================================");
		}
}

void outputOneData(char key,Student * iStu)
{
    char ch[20];
    Student*p = iStu;

    switch(key)
    {
    case '1':
        puts("请输入要查询的学生的学号");
        scanf("%s",ch);
        //
        while(p->next != NULL)
        {
            if(strcmp(p->number,ch) == NULL)
                {
                    puts("学号\t姓名\t性别\t高数\tc语言\t英语\t总分\t平均分\t名次");

                    printf("%-4s\t%-4s\t", p->number, p->name);
                    if (p->sex == 0)
                        printf("女");
                    else
                        printf("男");
                    printf("\t%-6.2lf\t%-6.2lf\t%-6.2lf\t%-6.2lf\t%-6.2lf\t%d\n", p->score.cProgram, p->score.math, p->score.english,p->score.math + p->score.cProgram + p->score.english,p->average_score,p->ranking);

                    puts("按任意键清屏");
                    getch();

                    break;
                }
            p = p->next;
        }
        printf("未查询到该学生信息，请核对后输入！！");
        break;
    case '2':
        puts("请输入要查询的学生的姓名");
        scanf("%s",ch);
        //
        while(p->next != NULL)
        {
            if(strcmp(p->name,ch) == NULL)
                {
                   puts("学号\t姓名\t性别\t高数\tc语言\t英语\t总分\t平均分\t名次");

                   printf("%-4s\t%-4s\t", p->number, p->name);
                   if (p->sex == 0)
                      printf("女");
                    else
                        printf("男");
                    printf("\t%-6.2lf\t%-6.2lf\t%-6.2lf\t%-6.2lf\t%-6.2lf\t%d\n", p->score.cProgram, p->score.math, p->score.english,p->score.math + p->score.cProgram + p->score.english,p->average_score,p->ranking);

                    puts("按任意键清屏");
                    getch();

                    break;
                }
            p = p->next;
        }
        printf("未查询到该学生信息，请核对后输入！！");
        break;
    case '3':
        puts("请输入要查询的学生的名次");
        scanf("%s",ch);
        //
        while(p->next != NULL)
        {
            if(p->ranking == atoi(ch))
                {
                    puts("学号\t姓名\t性别\t高数\tc语言\t英语\t总分\t平均分\t名次");

                    printf("%-4s\t%-4s\t", p->number, p->name);
                    if (p->sex == 0)
                        printf("女");
                    else
                        printf("男");
                    printf("\t%-6.2lf\t%-6.2lf\t%-6.2lf\t%-6.2lf\t%-6.2lf\t%d\n", p->score.cProgram, p->score.math, p->score.english,p->score.math + p->score.cProgram + p->score.english,p->average_score,p->ranking);

                    puts("按任意键清屏");
                    getch();

                    break;
                }
            p = p->next;
        }
        printf("未查询到该学生信息，请核对后输入！！");

        break;
    default :
        ;
       // fprintf(stderr,"输入有误，请重新输入\n");
    }

}
//名次排序
void sort_ranking(Student*head)
{
	Student*p1 = head;

	int len = 0;

	double maxNum = 0;
	//使ranking设为0
	while(p1->next != NULL)
    {
        p1->ranking = 0;
        p1 = p1->next;
    }
    p1 = head;
	//获取链表长度
	while(p1->next != NULL)
    {
        p1 = p1->next;
        len++;
    }
	int n = 0;

	while(len > 0)
	{
	    Student*q = head;
	    //找出未得出名次的成员
	    while(q->next != NULL)
        {
            if(q->ranking == 0)
                {
                    maxNum = q->average_score;
                    break;
                }
            q = q->next;
        }
	    n++;
        Student*p2 = head;
        //只和未排名的人进行比较
		while(p2->next != NULL)
		{
		    if(p2->ranking == 0)
            {
                maxNum = maxNum > p2->average_score?maxNum:p2->average_score;
  /*              if(maxNum > p2->average_score)
                    continue;
                else if(maxNum < p2->average_score)
                    maxNum = p2->average_score;
                else
                    continue;//*/
            }
            p2 = p2->next;
		}
		p2 = head;
		//匹配最大值，并赋值给名次
		while(p2->next != NULL)
        {
            if(p2->ranking == 0 && maxNum == p2->average_score)
            {
                p2->ranking = n;
                printf("%s获得名次%d\n",p2->name,p2->ranking);
                break;
            }
            p2 = p2->next;
        }
		len--;
	}//end len(1)
}
