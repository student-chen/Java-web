// StudentManageSystem.cpp : 定义控制台应用程序的入口点。
#include "stdio.h"
#include "stdlib.h"
#include "LinkedList.cpp"
#include "ScoreLevel.h"

#define N 20
#define FILE_NAME "test.bin"

int getLegalKey();

Student*init();
extern FILE*openFile(char*fileName);
extern Student*readBinaryFile(FILE*fp);
extern void outputAllData(Student * iStu);
extern void outputOneData(char key,Student * iStu);
extern void writeBinaryFile(Student*head,FILE*fp);
extern void sort_ranking(Student*head);

void mainScene();
void firstScene(Student*stu);
void secondScene();
void thirdScene();
void fourthScene();
void fifthScene();
void sixthScene();
void seventhScene();
void eighthScene();
void ninthScene();

void cleanPrint();
//全局变量
//接收按键操作
int key = 0;
Student*headGloble = NULL;
FILE*fpGloble = NULL;


int main(int argc, char* argv[])
{

	headGloble = init();
	if(headGloble == NULL)
	{
		puts("链表为空，按任意键继续");
		getch();
	}
	while(1)
	{
	cleanPrint();
	mainScene();
	key = getLegalKey();
	switch(key)
	{
	case '0' :
		if(headGloble != NULL)
		{
			fpGloble = fopen(FILE_NAME,"wb");
			writeBinaryFile(headGloble,fpGloble);
		}
		fclose(fpGloble);
		return 0;//后续将会修改
		break;
	case '1' : firstScene(headGloble);
		break;
	case '2' : secondScene();
		break;
	case '3' : thirdScene();
		break;
	case '4' : fourthScene();
		break;
	case '5' : fifthScene();
		break;
    case '6' : sixthScene();
        break;
    case '7': seventhScene();
		break;
    case '8':  eighthScene();
        break;
    case '9': ninthScene();
		break;
	default :  ;//
	}//end switch
	}
	return 0;
}
//获取合法操作
int getLegalKey()
{
	//...
	int k = getchar();
	while(getchar() != '\n')
        continue;
    return k;
}
//清屏函数。便于移植
void cleanPrint()
{
    #ifdef __linux
    clrscr();
    #else
	system("cls");
	#endif
}
//初始化，打开文件，并赋值给链表
Student*init()
{
	if((fpGloble = openFile(FILE_NAME)) == NULL)
	{
		fprintf(stdout,"文件不存在或打开失败,按键取消此次提醒");
		getch();
		return NULL;
	}
	return readBinaryFile(fpGloble);
}
//程序主界面
void mainScene()
{
	puts("==========================================================================");
	puts("|                                                                        |");
	puts("|                      欢迎使用学生成绩管理系统                          |");
	puts("|                                                                        |");
	puts("==========================================================================");
	puts("*          1.显示所有学生成绩             6.删除全部数据                 *");
	puts("*                                                                        *");
	puts("*          2.显示某一学生成绩             7.显示各分段成绩人数           *");
	puts("*                                                                        *");
	puts("*          3.增加学生数据                 8.导出文件（excel可打开文件）  *");
	puts("*                                                                        *");
	puts("*          4.删除学生信息                 9.关于作者                     *");
	puts("*                                                                        *");
	puts("*          5.修改学生信息                                                *");
	puts("*                                                                        *");
	puts("*                      0.安全退出学生成绩管理系统                        *");
	puts("==========================================================================");
}
//
void firstScene(Student*stu)
{
	Student*head = stu;
    Student*p = stu;

    int stu_num = 0;
    double math_average = 0,cProgram_average = 0,english_average = 0;

do{
        if(head == NULL)
          break;
            //计算每科总成绩*/
        while(p->next != NULL)
        {
            math_average += p->score.math;
            cProgram_average += p->score.cProgram;
            english_average += p->score.english;
            stu_num++;

            p = p->next;
        }
        //计算平均数
        math_average /= stu_num;
        cProgram_average /= stu_num;
        english_average /= stu_num;
    }while(0);

	while(1)
	{
		cleanPrint();
		if(head == NULL)
			printf("当前文件没有数据，请先输入数据\n"
			"                  0.返回上一级菜单\n");
		else
		{
			outputAllData(head);
			//显示平均数
			puts("============================各科平均分数============================\n");
			printf("                        %-6.2lf\t%-6.2lf\t%-6.2lf\n",math_average,cProgram_average,english_average);
			puts("\n=======================0.返回上一级菜单=======================");
		}
		key = getLegalKey();

		switch(key)
		{
		case '0' : return ;//返回上一级代码
			break;
		case '1' :
			break;
		case '2' :
			break;
		case '3' :
			break;
		default : ;//
		}
	}
}
//第二个操作界面
void secondScene()
{
	while (1)
	{
		cleanPrint();
		puts("                        二.显示某一学生成绩\n根据\n"
			"                     1.学号\n"
			"                     2.姓名\n"
			"                     3.名次\n查找学生信息");
		puts("                         0.返回上一菜单      ");
		puts("******************************************************");

		if(headGloble == NULL)
		{
		    puts("当前无数据，无法进行查询操作，按任意键返回上一级");
		    getch();
		    return ;
		}
		key = getLegalKey();

		if(key == '0')
            return ;
        else
            outputOneData(key,headGloble);
    }
}
//三界面，动态添加数据
void thirdScene()
{
	while(1)
	{
	cleanPrint();

	if(headGloble == NULL)
	{
		puts("文件为空，请输入.\n注：至少输入一项");
		headGloble = buildList();
		puts("输入成功，按任意键返回上一菜单");
		getch();
		return ;
	}
	else
	{
		puts("                       三.增加学生数据");
		puts("输入时请注意学号不能相同");
		puts("请输入学生数据：（注：当学号为0时退出数据添加）");

		while(1)
		{
		    puts("学号     姓名   性别    数学   c语言    英语");

			Student*p = headGloble;
			Student*p1 = (Student*)malloc(sizeof(Student));
			Student*p2 = headGloble;

			scanf("%s",p1->number);

			if(strcmp(p1->number,"0") == NULL)
			{
			    //排列名次，
			    {
			                   //定义一变量，来重新改名次
			                   //int n = 1;
			        Student*q1 = headGloble,*q2 = headGloble;

			        while(q1->next != NULL)
                    {
                        q1->ranking = 0;
                        q1 = q1->next;
                    }
			        sort_ranking(q2);
			    }
			    //end sort
				//退出输入
				free(p1);
				printf("数据结束输入，按任意键返回上一菜单\n");
				//清楚缓冲区
				while (getchar() != '\n')
				continue;

				getch();
				return ;
			}
			else
				scanf("%s%d%lf%lf%lf", p1->name, &p1->sex, &p1->score.cProgram, &p1->score.math,&p1->score.english);
			//判断是否有相同的学号
			while(p->next != NULL)
			{
				if(strcmp(p1->number,p->number) == NULL)
				{
					printf("您输入的学生信息的学号已存在，请重新输入！\n");
					break;
				}
				p = p->next;
			}
			//判断输入的学号是否已经存在，如果存在，则取消此次循环
			if(p->next != NULL)
                continue;
			while(p2->next->next != NULL)
				p2 = p2->next;
			//加入到链表
            p2->next = p1;
			p1->next = p;

//			p1->ranking = n;
			p1->average_score = (p1->score.math + p1->score.cProgram + p1->score.english)/3;

		}///end while(1)

	}//else
	}

}
//四界面，删除学生信息
void fourthScene()
{
    char ch[20];
    Student*p1 = headGloble,*p2 = NULL;

	while(1)
	{
	cleanPrint();
	puts("                       四.删除学生数据");
	puts("根据");
	puts("                    1.学号\n"
		 "                    2.学生名字\n"
		 "                  删除学生数据");
	puts("======================0.返回上一菜单======================");

	if(p1 == NULL)
    {
        puts("当前无数据，无法进行删除操作，按任意键返回上一级");
        getch();
        return ;
    }
	//后续修改
	key = getLegalKey();

	switch(key)
	{
	case '0' : return ;//返回上一级代码
		break;
	case '1' :
	    puts("请输入要删除的学生的学号");
	    scanf("%s",ch);
	    //如果删除的是头节点
	    if(strcmp(p1->number,ch) == NULL)
            {
                headGloble = headGloble->next;
                //释放头节点空间
                free(p1);
                //重新排列名次
                Student*p = headGloble;
                while(p->next != NULL)
                {
                    p->ranking = 0;
                    p = p->next;
                }
                sort_ranking(headGloble);

                printf("该学生信息已删除。按任意键继续");
                getch();
                break;
            }
	    //找到要删除的学生的前一个学生节点
	    while(p1->next->next != NULL)
        {
            if(strcmp(p1->next->number,ch) == NULL)
            {
                p2 = p1->next;
                p1->next = p2->next;

                free(p2);
                //重新排列名次
                Student*p = headGloble;
                while(p->next != NULL)
                {
                    p->ranking = 0;
                    p = p->next;
                }
                sort_ranking(headGloble);

                printf("该学生信息已删除。按任意键继续");
                getch();
                break;
            }
            p1 = p1->next;
        }//end while
        fprintf(stderr,"未找到该与该学号匹配的学生信息，请核对后再操作\n按任意键返回\n");
        getch();
		break;
	case '2' :
	    puts("请输入要删除的学生的姓名");
	    scanf("%s",ch);
	    //如果删除的是头节点
	    if(strcmp(p1->name,ch) == NULL)
            {
                headGloble = headGloble->next;
                //释放头节点空间
                free(p1);
                //重新排列名次
                Student*p = headGloble;
                while(p->next != NULL)
                {
                    p->ranking = 0;
                    p = p->next;
                }
                sort_ranking(headGloble);

                printf("该学生信息已删除。按任意键继续");
                getch();
                break;
            }
	    //找到要删除的学生的前一个学生节点
	    while(p1->next->next != NULL)
        {
            if(strcmp(p1->next->name,ch) == NULL)
            {
                p2 = p1->next;
                p1->next = p2->next;

                free(p2);
                //重新排列名次
                Student*p = headGloble;
                while(p->next != NULL)
                {
                    p->ranking = 0;
                    p = p->next;
                }
                sort_ranking(headGloble);

                printf("该学生信息已删除。按任意键继续");
                getch();
                break;
            }
            p1 = p1->next;
        }//end while
        fprintf(stderr,"未找到该与该学号匹配的学生信息，请核对后再操作\n按任意键返回\n");
        getch();
		break;
	default : ;//
		}
	}

}
//五界面，删除学生信息
void fifthScene()
{
    Student*p = headGloble;

    Student stu;
	while(1)
	{
	cleanPrint();
	puts("                   五.修改学生信息");
	puts("\n                     1.修改信息\n");
//	puts("请输入学号\n注：因为每个人学号固定，但姓名不固定，所以只提供通过学号修改");
	puts("============================0.返回上一菜单==============================");
	//后续修改
	key = getLegalKey();
	//
	if(key == '0')
        return ;
    else if(key == '1')
    {
        char num[20];
        puts("请输入要修改的学生信息的学号");
        scanf("%s",num);

        p = headGloble;
        //找到要修改的数据
        while(p->next != NULL)
        {
            if(strcmp(p->number,num) == NULL)
            {
                puts("原数据");
                puts("学号\t姓名\t性别\t高数\tc语言\t英语\t总分\t平均分\t名次");

                printf("%-4s\t%-4s\t", p->number, p->name);
                if (p->sex == 0)
                    printf("女");
                else
                    printf("男");
                printf("\t%-6.2lf\t%-6.2lf\t%-6.2lf\t%-6.2lf\t%-6.2lf\t%d\n", p->score.cProgram, p->score.math, p->score.english,p->score.math + p->score.cProgram + p->score.english,p->average_score,p->ranking);
                puts("请输入新数据(注：请不要修改学号)，性别 1为男 0位女");
                puts("学号 姓名 性别 高数 c语言 英语");

                scanf("%s%s%d%lf%lf%lf",stu.number,stu.name,&stu.sex,&stu.score.math,&stu.score.cProgram,&stu.score.english);

                for(int i = 0;i < 20;i++)
                p->name[i] = stu.name[i];

                p->sex = stu.sex;
                p->score.math = stu.score.math;
                p->score.cProgram = stu.score.cProgram;
                p->score.english = stu.score.english;
                //修改平均分
                p->average_score = (p->score.math + p->score.cProgram + p->score.english)/3;
                //修改名次
                p = headGloble;
                while(p->next != NULL)
                {
                    p->ranking = 0;
                    p = p->next;
                }
                sort_ranking(headGloble);

                puts("数据修改成功，按任意键继续");
                getch();
                break;
            }
            p = p->next;
        }
        fprintf(stderr,"未找到该学号匹配的学生，按任意键继续\n");
        getch();
    }

	}//end while
}
//第六界面，删除全部数据
void sixthScene()
{
    Student* p = headGloble,*head = headGloble;

    if(headGloble == NULL)
    {
        cleanPrint();

        puts("当前无数据，无法进行删除操作，按任意键返回上一级");
        getch();
        return ;
    }
    while(1)
    {
        cleanPrint();
        printf("             六。删除全部数据\n");
        puts("是否删除全部数据？注：清空后则删除全部数据，且无法找回，是否继续？\n"
             "                                   1.是\n"
             "                                   2.否");
        key = getLegalKey();
        if(key == '1')
        {
          //释放链表全部空间
          while(head->next != NULL)
          {
              head = head->next;
              free(p);
              p = head;
          }
          //清空文件内容
          fpGloble = fopen(FILE_NAME,"wb");

          headGloble = NULL;

          puts("数据已清空，按任意键返回上一级");
        }
        else
        {
            puts("取消删除操作。。按任意键返回上一级");
        }
        getch();
        return ;
    }
}
//第七界面，显示各分段人数
void seventhScene()
{
    void put(char num[]);
    void add(char number[],int*stu_num,char scoreLevel[]);

    //储存每个分段，不同科目下的人数
    int a[4][3] = {0};
    struct Level level = {0};
    Student*p = headGloble;

    if(p == NULL)
    {
        puts("现在没有数据，无法进行操作\n按任意键返回");
        getch();
    }

    while(p->next != NULL)
    {
        //数学
        if(p->score.math > 90.0 && p->score.math <= 100.0)
            add(p->number,&a[0][0],level.A.math_num);
        else if(p->score.math > 70.0 && p->score.math <= 90.0)
            add(p->number,&a[1][0],level.B.math_num);
        else if(p->score.math > 60.0 && p->score.math <= 70.0)
            add(p->number,&a[2][0],level.C.math_num);
        else if(p->score.math >= 0.0 && p->score.math <= 60.0)
            add(p->number,&a[3][0],level.D.math_num);
        //c语言
       if(p->score.cProgram > 90.0 && p->score.cProgram <= 100.0)
            add(p->number,&a[0][1],level.A.cProgram_num);
        else if(p->score.cProgram > 70.0 && p->score.cProgram <= 90.0)
            add(p->number,&a[1][1],level.B.cProgram_num);
        else if(p->score.cProgram > 60.0 && p->score.cProgram <= 70.0)
            add(p->number,&a[2][1],level.C.cProgram_num);
        else if(p->score.cProgram >= 0.0 && p->score.cProgram <= 60.0)
            add(p->number,&a[3][1],level.D.cProgram_num);
        //英语
        if(p->score.english > 90.0 && p->score.english <= 100.0)
            add(p->number,&a[0][2],level.A.english_num);
        else if(p->score.english > 70.0 && p->score.english <= 90.0)
            add(p->number,&a[1][2],level.B.english_num);
        else if(p->score.english > 60.0 && p->score.english <= 70.0)
            add(p->number,&a[2][2],level.C.english_num);
        else if(p->score.english >= 0.0 && p->score.english <= 60.0)
            add(p->number,&a[3][2],level.D.english_num);

        p = p->next;
    }//end 数据准备阶段
    while(1)
    {
        cleanPrint();

        puts("======================0.返回上一菜单====================");
        printf("各分段人数\t高数\tc语言\t英语\n");
        printf("90＜x≤100\t%d\t%d\t%d\t\n",a[0][0],a[0][1],a[0][2]);
        puts("");
        printf("70＜x≤90\t%d\t%d\t%d\t\n",a[1][0],a[1][1],a[1][2]);
        puts("");
        printf("60＜x≤70\t%d\t%d\t%d\t\n",a[2][0],a[2][1],a[2][2]);
        puts("");
        printf("≤60\t\t%d\t%d\t%d\t\n",a[3][0],a[3][1],a[3][2]);
        puts("");
        puts("1.查询某一分数线下的学生");
        puts("========================================================");
        key = getLegalKey();
        switch(key)
        {
        case '0': return;
            break;
        case '1':
            puts("输入想要查询的分数段：\n"
                 "\t\t1:90＜x≤100\n"
                 "\t\t2:70＜x≤90\n"
                 "\t\t3:60＜x≤70\n"
                 "\t\t4:≤60");
            key = getLegalKey();
            switch(key)
            {
            case '1':
                puts("请输入要查询的科目\n"
                     "1.数学\t2.c语言\t3.英语");
                key = getLegalKey();
                if(key == '1')
                    put(level.A.math_num);
                else if(key == '2')
                    put(level.A.cProgram_num);
                else if(key == '3')
                    put(level.A.english_num);
                else
                    fprintf(stderr,"输入有误");
                puts("按任意键继续");
                getch();
                break;
            case '2':
                puts("请输入要查询的科目\n"
                     "1.数学\t2.c语言\t3.英语");
                key = getLegalKey();
                if(key == '1')
                    put(level.B.math_num);
                else if(key == '2')
                    put(level.B.cProgram_num);
                else if(key == '3')
                    put(level.B.english_num);
                else
                    fprintf(stderr,"输入有误");
                puts("按任意键继续");
                getch();
                break;
            case '3':
                puts("请输入要查询的科目\n"
                     "1.数学\t2.c语言\t3.英语");
                key = getLegalKey();
                if(key == '1')
                    put(level.C.math_num);
                else if(key == '2')
                    put(level.C.cProgram_num);
                else if(key == '3')
                    put(level.C.english_num);
                else
                    fprintf(stderr,"输入有误");
                puts("按任意键继续");
                getch();
                break;
            case '4':
               puts("请输入要查询的科目\n"
                     "1.数学\t2.c语言\t3.英语");
                key = getLegalKey();
                if(key == '1')
                    put(level.D.math_num);
                else if(key == '2')
                    put(level.D.cProgram_num);
                else if(key == '3')
                    put(level.D.english_num);
                else
                    fprintf(stderr,"输入有误");
                puts("按任意键继续");
                getch();
                break;
            }//end switch
            break;
        }
    }
}
void add(char number[],int*stu_num,char scoreLevel[])
{
    *stu_num += 1;

    sprintf(&scoreLevel[strlen(scoreLevel)],"%s ",number);

    if(strlen(scoreLevel) >= sizeof(scoreLevel))
        fprintf(stderr,"存储空间不足！");
}
//输出与该学号对应的学生信息
void put(char num[])
{
    Student*p = headGloble;
    char number[20] = {'\0'};
    int i = 0;
    //调试
    if(strlen(num) == 0)
        printf("该范围内没有学生，请核对后重试\n");
    else
    puts("学号\t姓名\t性别\t高数\tc语言\t英语\t总分\t平均分\t名次");
    //匹配学号
    while(num[i] != '\0')
    {
        //读取字符串
        sscanf(&num[i],"%s",number);

        while(p->next != NULL)
        {
            if(strcmp(p->number,number) == NULL)
            {
                    printf("%-4s\t%-4s\t", p->number, p->name);
                    if (p->sex == 0)
                        printf("女");
                    else
                        printf("男");
                    printf("\t%-6.2lf\t%-6.2lf\t%-6.2lf\t%-6.2lf\t%-6.2lf\t%d\n", p->score.cProgram, p->score.math, p->score.english,p->score.math + p->score.cProgram + p->score.english,p->average_score,p->ranking);
                    break;
            }
            p = p->next;
        }
        i += strlen(number) + 1;
    }
}
void eighthScene()
{
    Student*p = headGloble;

    if(p == NULL)
    {
        puts("当前无数据，无法进行导出操作，按任意键返回上一级");
        getch();
        return;
    }
 while(1)
    {
        cleanPrint();
        puts("                        八。导出文件");
        printf("是否导出文件（\n注：将导出.csv文件 .csv文件可以被excel打开，如需要可以升级为更高级的，具体请自行摸索\n）");
        puts("导出文件会覆盖当前文件，文件名为 学生信息.csv");
        puts("1.确定导出 \n0.返回上一级");
        key = getLegalKey();
        if(key == '1')
        {
            FILE*fp = fopen("学生信息.csv","w");

            fprintf(fp,"学号,姓名,性别,高数,c语言,英语,总分,平均分,名次\n");

            while(p->next != NULL)
            {
                fprintf(fp,"%s,%s,", p->number, p->name);

                if (p->sex == 0)
                    fprintf(fp,"女,");
                else
                    fprintf(fp,"男,");

                fprintf(fp,"%lf,%lf,%lf,%lf,%lf,%d\n", p->score.cProgram, p->score.math, p->score.english,p->score.math + p->score.cProgram + p->score.english,p->average_score,p->ranking);

                p = p->next;
            }
            printf("文件导出成功！，按任意键返回上一级");
            fclose(fp);
            getch();
            return ;
        }
        else if(key == '0')
            return ;
        puts("按任意键返回上一级");

        getch();
        return;
    }
}
void ninthScene()
{
    while(1)
    {
        cleanPrint();
        puts("                        九。关于");
        puts("本程序由优秀开发人员 任小牛 耗时，以及斥资2000000000000000000000\n实乃居家旅行，杀人必备产品，");
        puts("附：\n              \t花痴诗 出处 魁拔\n\n");
        puts("\t\t我的小鱼你醒了，还认识早晨吗 \n"
             "\t\t昨夜你曾经说 愿夜幕永不开启 \n"
             "\t\t你的香腮边 轻轻滑落的 是你的泪 还是我的泪\n"
             "\t\t初吻吻别的那个季节 不是已经哭过了吗 \n"
             "\t\t我的指尖还记忆着 你慌乱的心跳 \n"
             "\t\t温润的体香里 那一缕长发飘飘\n");
        puts("按任意键返回上一级");
        getch();
        return;
    }
}
