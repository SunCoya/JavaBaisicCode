package Day16_JigsawPuzzle;

public class App {
    public static void main(String[] args) {
        new GameFrame();
    }
}

/*
项目阶段：
 1.创建窗口类继承于JFrame，并在构造方法里面初始化窗口（设置大小，设置标题，设置居中，设置关闭方式，设置游戏界面总在上方，设置为可见，设置layout为空，使得组件不会默认居中），提取成初始化方法
 2.创建JMB，JM，JMI，再把JMI给JM，把JM给JMB，把JB给JF。
 3.初始化图片initImage方法，把图片放到JL（JL相当于是图片的容器！）里面，再把JL放到窗口的隐藏容器里面，在方法中给图片添边框，移动图片到窗口正中间：（在初始化图片的时候添加坐标即可）
 4.打乱图片initDate顺序
 5.添加背景图片（在初始化拼图图片后）
 6.给游戏添加键盘监听（不是点击图片）：增加上下左右四种情况：并且在InitImage里面去删除原来的图片，并刷新一下界面
 7.添加查看完整图片功能，按住A显示完整图片，松开A显示随机打乱的图片
 8.作弊功能：按下按钮W，游戏方块全部回到原位
 9.显示胜利：在加载图片前判断就行（为了让胜利显示在最上层）：之前的想法是在键盘监听中判断：但是那样无效的键盘监听也会有代码运行。游戏胜利之后无法再次按按键
 10.添加计步功能：不会添加文字，在按下上下左右键之后count++即可定义全局变量，也需要在initImage里面初始化
 11.添加重新游戏功能：设置重新点击动作，再把数据重新init就可以咯
 12.添加新的菜单栏：更换图片：更换图片里面有三个小选项
 13. 把图片存储位置先提取出来。添加转换图片功能额：增加三个小监听即可，随机图片就是改个路径即可：由于是全局变量，按A也能够显示对应的图片

（11.25）
 14.加入存档读档功能：新增JM与JB（定义在最外层的static代码中）,吧JB全部加上监听
 15.存档需要存储数据：把数据序列化:需要路径，步数，空白位置，图片位置，包装成一个类：并实现Serializable接口
 16.完成存档读档功能，需要注意存档文件的名字，修改界面上的存读档文字
 17.完成根据存档初始化JMenu
 18.完成配置文件功能，可以修改properties中的文件去更换图片

*/
