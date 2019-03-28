package pojo;


import java.sql.Timestamp;

public class StuRandom {
    private  static String[] leftName={"赵","钱","孙","李","周","吴","郑","王","冯","陈","褚","卫","蒋","沈","韩","杨","朱",
            "秦","尤", "许","何","吕","施","张","孔","曹","严","华","金","魏","陶","姜","戚","谢","邹","喻","柏","水","窦",
            "章","云", "苏","潘","葛","奚","范","彭","郎","鲁","韦","昌","马","苗","凤","花","方","俞","任","袁","柳","酆",
            "鲍","史", "唐","万俟","司马","上官","欧阳","夏侯","诸葛","闻人","东方","赫连","皇甫","尉迟","澹台","公孙", "轩辕",
            "令狐", "宇文","慕容","司徒","司空","端木","西门","南宫","第五"};
    private static String[] boyName={"彬","轩","含","蒲","乒","虚","行","亭","仑","蓝","影","韬","函","克","盛","衡","芝",
            "晗","昊","诗", "琦","至","涵","伦","时","映","志","菱","纶","士","永","致","嘉","旷","示","咏","智","安","轮",
            "世","勇","中", "昂","律","业","友","忠","敖","齐","轼","桓","林","言","群","书","有","宣","颁","略","伟","骢",
            "州","清","宏", "充","佑","洲","庭","马","濮","丹","乐","邦","迈","卫","平","乾","榜","宸","蔚","旲","东","宝",
            "昴","树","材", "纪","保","茂","泓","棋","竹","葆","浩","魏","妤","铸","劻","玫","晔","渝","壮","羚","阳","文",
            "瑜","卓","掣", "奎","船","与","萱","豹","梅","汶","旭","濯","驾","和","航","宇","孜","邶","望","武","羽","崊",
            "霆","美","希", "雨","淑","冰","蒙","才","凰","腾","备","密","溪","泰","子","辈","冕","帅","语","茜","蓓","淼",
            "曦","玉","梓", "弼","民","奇","禾","综","碧","洋","霞","连","祖","厚","晨","先","昱","选","昪","旻","虹","朔",
            "济","彪","淏", "贤","儋","冬","龄","馗","娴","钰","栋","飙","传","舷","御","端","澜","然","磊","裕","段","挺",
            "名","春","誉", "天","飚","明","灏","堂","碫","莱","鸣","双","渊","琳","坚","茗","一","元","倩","宾","村","宪",
            "辉","铎","妍", "铭","献","彭","思","策","谋","祥"};
    private static String[] girlName={"滢","漪","漫","澜","灵","煜","燕","玉","玥","玫","环","玲","珂","珊","珍","珠","姬",
            "娅","娆", "娇","娉","娜","娟","娣","娥","娴","婉","婕","婧","婵","婷","媚","媛","嫔","嫣","嫱","安","宛","宜",
            "宝","容", "巧","希","彤","彩","心","忆","念","怀","怜","思","怡","情","惠","慧","敏","旭","春","晴","曼","月",
            "琦","琪", "琬","琰","琳","琴","琼","瑗","瑛","瑜","瑶","瑾","璇","璐","璟","白","盈","盼","碧","秀","筠","红",
            "绮","美", "翠","艳","芃","芊","芝","芬","芮","芯","芳","芷","芸","苑","若","苹","茗","茜","茵","茹","荔","荭",
            "荷","莉", "莎","莲","莹","菁","菡","菲","萍","萱","蓉","蓓","蔓","蕊","蕾","薇","诗","语","贞","采","钰","银",
            "雅","雨", "雪","雯","霏","霖","霜","霞","露","青","靖","静","音","韵","颖","颜","香","馨","黛"};
    private static String[] jobType={"java","css","js","pm","ui","动画师","op","运营","qa","java","java","java","java",
            "java","java","java","java","css","css","css","css","css","css","css","css","css","css","css","css","css",
            "css","css","js","js","js","js","js","js","js","js","js","qa","qa","qa","qa","pm","pm","pm","pm","pm", "pm",
            "pm","pm","pm","pm","java","java","java","java","java","java","java","java","css","css","css","css", "css",
            "css","css","css","css","css","css","css","css","css","css","js","js","js","js","js","js","js","js", "js",
            "qa","qa","qa","qa","pm","pm","pm","pm","pm"};


    private static int getNum(int start,int end){
        return (int) (Math.random()*(end-start+1)+start);
    }


    /**
     * 随机姓名
     */
    public  String getStuName(){
        String lastName;
        String firstName;
        /*生成0，1判断性别*/
        int gender= (int) (Math.random()*2);
        if (0==gender){
            lastName=getRightName(girlName);
        }else {
            lastName=getRightName(boyName);
        }
        firstName=getLeftName(leftName);
        String name=firstName+lastName;
        return name;
    }

    /**
     *生成随机QQ
     */
    public  String getQq(int min,int max){
        int length=getNum(min,max);
        StringBuffer sb=new StringBuffer();
        int firstNum=getNum(1,9);
        sb.append(firstNum);
        for (int i=0;i<length;i++){
            int num=getNum(0,9);
            sb.append(num);
        }
        String qq=sb.toString();
        return qq;
    }

    /**
     * 随机职业
     */
    public String getJob(){
        String job=jobType[getNum(1,jobType.length)-1];
        return job;
    }


    /**
     *
     * 创建时间
     */
    public Long createAt(){

        double time =Math.random();
        Long created=System.currentTimeMillis()-getNum(0,1500000000);
        return created;
    }


    public Long updateAt(){
        Long updated=System.currentTimeMillis()-getNum(0,1500000000);
        return updated;
    }

    /*生成姓*/
    private static String getLeftName(String[] surnames){
        String firstName=surnames[getNum(1,surnames.length-1)];
        return firstName;
    }
    /*生成名*/
    private static String getRightName(String[] gender){
        String lastName;
        String rightName=gender[getNum(1,gender.length-1)];
        String secName=gender[getNum(1,gender.length-1)];
        int midName= (int) (Math.random()*2);

        if (0==midName){
            lastName=secName+rightName;
        }else {
            lastName=rightName;
        }
        return lastName;
    }
    

}







