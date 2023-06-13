package com.shahruie.www.Knowledge_Train;

/**
 * Created by MR on 12/14/2017.
 */
public class Question_library {

    int img_of_words[]={R.drawable.snow,R.drawable.rain
            ,R.drawable.cold,R.drawable.green,R.drawable.red,R.drawable.white,
            R.drawable.oil,R.drawable.hen,R.drawable.dog,R.drawable.cat,R.drawable.zoo
            ,R.drawable.potato,R.drawable.tomato,R.drawable.moon,R.drawable.star
            ,R.drawable.sun,R.drawable.book,R.drawable.bookstory,
            R.drawable.notebook,R.drawable.head,R.drawable.eye,
            R.drawable.ear,R.drawable.bus,R.drawable.car,
            R.drawable.baby,R.drawable.girl,R.drawable.boy,R.drawable.father,
            R.drawable.mather,R.drawable.tv,R.drawable.radio,
    R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,
    R.drawable.five,R.drawable.six,R.drawable.seven, R.drawable.eight, R.drawable.nine,R.drawable.ten,
    R.drawable.zero};
    int sound_of_ewords[]={R.raw.snow,R.raw.rain,R.raw.cold,
            R.raw.green,R.raw.red,R.raw.white,R.raw.oil,R.raw.hen,
            R.raw.dog,R.raw.cat,R.raw.zoo,R.raw.potato,R.raw.tomato,
            R.raw.moon,R.raw.star,R.raw.sun,
            R.raw.book,R.raw.book_story,R.raw.note_book,R.raw.head,
            R.raw.eye,R.raw.ear,R.raw.bus,
            R.raw.car,R.raw.baby,R.raw.girl,R.raw.boy,R.raw.father,
            R.raw.mather,
            R.raw.tv,R.raw.radio,R.raw.one,
    R.raw.two,R.raw.three,R.raw.four,R.raw.five,
    R.raw.six,R.raw.seven,R.raw.eight,R.raw.nine,R.raw.ten,R.raw.zero};

    String ewords[]={
            "برف","باران","سرد","سبز","قرمز",
            "سفید","نفت","مرغ","سگ","گربه",
            "باغ وحش","سیب زمینی","گوجه","ماه","ستاره",
            "خورشید","کتاب","کتاب داستان","دفتریادداشت","سر",
            "چشم","گوش","اتوبوس","ماشین","نوزاد",
            "دختر","پسر","پدر","مادر","تلویزیون",
            "رادیو","یک","دو","سه","چهار",
            "پنج","شش","هفت","هشت","نه",
            "ده","صفر"


    };

    String ostanha[]={
            "تهران","خوزستان","قم","مازندران","گیلان",
            "گلستان","اردبیل","آذربایجان شرقی","آذربایجان غربی","خراسان شمالی",
            "سمنان","قزوین","زنجان","کردستان",
            "خراسان رضوی","همدان","کرمانشاه","اصفهان","یزد","خراسان جنوبی",
            "لرستان","ایلام","چهارمحال بختیاری",
            "کهگلویه و بویر احمد","فارس","کرمان","سیستان و بلوچستان","بوشهر","هرمزگان","مرکزی","البرز"
    };
    

   int ostan_voice[]={R.raw.tehran,R.raw.ahvaz,R.raw.ghom,
           R.raw.sari,R.raw.rasht,R.raw.gorgan,R.raw.ardabil,R.raw.tabriz,
           R.raw.orumiyeh,R.raw.bojnurd,R.raw.semnan,R.raw.ghazvin,R.raw.zanjan,
           R.raw.kordestan,R.raw.mashhad,R.raw.hamadan,
           R.raw.kermanshah,R.raw.esfahan,R.raw.yazd,R.raw.birjand,
           R.raw.lorestan,R.raw.lam,R.raw.sharekord,
           R.raw.yasuj,R.raw.shiraz,R.raw.kerman,R.raw.sistan,R.raw.bushehr,
           R.raw.bandarabbas,
           R.raw.arak,R.raw.alborz};


		   
		   int emam_voice[]={R.raw.ali,R.raw.hasan,R.raw.hossain,
   R.raw.sajad,R.raw.bagher,R.raw.sadegh,R.raw.kazem,R.raw.reza,
   R.raw.taghi,R.raw.naghi,R.raw.askari,R.raw.mahdi};
   
    int dini_color[]={R.color.ali,R.color.hasan,R.color.hosain,R.color.sajad,
            R.color.bagher,R.color.sadegh,R.color.kazem,R.color.reza,
            R.color.taghi,R.color.hadi,R.color.askari,R.color.mahdi,

    };
   
  
    int inext_correct[]={
           0,1,2,2,1,2,1,0,2,0,1,2,0,2,1,0,2,1,0,1,0,2,1,0,2,1,1,0,1,2,1
   };
    int choice_question_of_center[][]={
            {0,21,3},{12,1,0},{4,3,2},
            {4,24,3},{27,4,8},{7,30,5},
            {1,6,15},{7,1,0},{10,23,8},
            {9,12,13},{29,10,11},{21,10,11},{12,23,7},
            {1,26,13},{22,14,0},{15,30,21},
            {10,27,16},{28,17,10},{18,30,12},
            {20,19,13},{20,18,19},{14,8,21},
            {25,22,16},{23,4,8},{7,5,24},
            {19,25,9},{17,26,30},{27,23,18},
            {19,28,11},{6,10,29},{12,30,20},

    };
    int mquestion_of_center[]={2,0,3};
    int manswer_of_center[]={2,0,3};

    String video_dini_path[]={
            "https://hw15.asset.aparat.com/aparat-video/af6aa48b8ecec09d28ad341d1786d1b65698343-240p__16554.mp4",
            "https://hw7.asset.aparat.com/aparat-video/375b8315537bbc851a17539f37ad6b1b8203130-360p__64483.mp4",
            "https://hw20.asset.aparat.com/aparat-video/f2cd8fb023171d760ee4a1916d25af839303305-240p__69940.mp4",
            "https://hw15.asset.aparat.com/aparat-video/069220fbc81191a1e6519dd773f49a734659833-360p__12983.mp4",
            "https://as3.asset.aparat.com/aparat-video/ef7eefb05e1f416fb8d88df13c8b7c2b9105559-240p__24539.mp4",
            "https://hw20.asset.aparat.com/aparat-video/52a5facca5646d2ce1b5fa2c4d2112329106674-360p__50591.mp4",
            "https://as5.asset.aparat.com/aparat-video/ec55dc7b7e1667c27705fd95ddbd3b009096219-240p__96833.mp4",
            "https://hw18.asset.aparat.com/aparat-video/389f4539dd4cece2a58d17a1c3daf55f8937549-360p__71817.mp4",
            "https://hw2.asset.aparat.com/aparat-video/4c76f13c56d2686e922fe7efc39e338f8214544-360p__88090.mp4",
            "https://hw6.asset.aparat.com/aparat-video/6b59ca421e4ee25d8ce1e87104b94ee48203132-360p__90362.mp4",
            "https://hw3.asset.aparat.com/aparat-video/9be633570eae9454a15a61ca6bdbbc741119660__66681.mp4",
            "https://as4.asset.aparat.com/aparat-video/c373a3fb7b410b23cda115b32be43c4d5466528-240p__59567.mp4",
            "https://hw6.asset.aparat.com/aparat-video/08f5ff497a5e0e8dc5867ac13ca5ce9d4371413-240p__94789.mp4",
            "https://as3.asset.aparat.com/aparat-video/2986c669b9cb5e727815a904f2e18e8b2999650-300p__48849.mp4",
            "https://hw16.asset.aparat.com/aparat-video/5671eb879952b0fd410eda01e11f9be56583373-360p__70087.mp4",
            "https://hw1.asset.aparat.com/aparat-video/ea6cc8a425a802bc700821adbe98d17a8216979-360p__55887.mp4",
            "https://hw1.asset.aparat.com/aparat-video/a4d509e1924f6ef39775206fb731b0108074460-360p__74623.mp4",
            "https://hw1.asset.aparat.com/aparat-video/325e6a047cb5175202b3ad04b762ae696005694-360p__60381.mp4",
            "https://hw4.asset.aparat.com/aparat-video/6e684e555308a3584778ca463f9cce776012603-360p__64420.mp4",
            "https://hw16.asset.aparat.com/aparat-video/a674404c6626f804bee9fdeeeb83cd1f3353977-360p__62395.mp4",
            "https://hw6.asset.aparat.com/aparat-video/1c0fd0a0c93a1c556ab465a04224fe1d5758012-360p__48767.mp4",
            "https://as8.asset.aparat.com/aparat-video/ed22a2cb74b130927324f4e5ac5b0c146735373-240p__61832.mp4",
            "https://as11.asset.aparat.com/aparat-video/8bb7209b7142ecdf8444749eb2548d287147578-288p__26825.mp4",
            "https://as1.asset.aparat.com/aparat-video/b7841310e95cd7bdd15395414106592e7588196-360p__76008.mp4",
            "https://as7.asset.aparat.com/aparat-video/33153870be2ab38a7674eaf0a132b16e382669__81248.mp4",
            "https://as1.asset.aparat.com/aparat-video/e64a05241426e58668c8286b19acb1a91404958__23056.mp4"
    };

    String dini_video_title[]={"دعای فرج امام زمان (عج)",
            "سوره های کوتاه قرآن برای کودکان",
            "سوره ناس توسط کودکان قرآن کودکان",
            "ن سوره نصر-قرآن اطفال",
            "آموزش حفظ قرآن سوره عصر برای کودکان",
            "سوره الناس آموزش قران برای کودکان خردسال",
            "آموزش حفظ قرآن سوره اخلاص (توحید) برای کودکا",
            "آموزش خیلی جذاب قرآن برای کودکان",
            "آموزش تصویری ۱۱ سوره قرآن به کودکان",
            "آموزش سوره اخلاص سوره های کوتاه قرآن با صدای کودک",
            "آموزش قرائت سوره کوثر برای کودکان به همراه معنی و شعر",
            "آموزش و حفظ قرآن کریم به کودکان سوره فلق",
            "آموزش قرآن به کودکان سوره فیل",
            "آموزش نماز برای کودکان با انیمیشن",
            "آموزش نماز به صورت انیمیشن کودک و نوجوان (چهار رکعتی)",
            "آموزش نماز با انیمیشن جذاب به کودکان",
            "آموزش یادگیری و خواندن نماز دو ركعتی برای کودکان",
            "آموزش وضو برای کودکان(دختران)",
            "آموزش وضو برای کودکان(پسران)",
            "آموزش وضو با شعر و انیمیشن برای کودکان",
            "انیمیشن آداب وضو گرفتن",
            "آموزش نماز ویژه کودکان(تیمم)",
            "آموزش 12 امام بصورت شعر و انیمیشن",
            "14معصوم(ویژه کودکان)",
            "کلیپ زیبای عشق 12 تا امام از گروه فیتیله"
    };
int dini_img[]={R.drawable.emam4,
        R.drawable.dini1,
        R.drawable.dini32,
        R.drawable.dini313,
        R.drawable.dini4,
        R.drawable.dini5,
        R.drawable.dini6,
        R.drawable.dini7,
        R.drawable.dini8,
        R.drawable.dini9,
        R.drawable.dini10,
        R.drawable.dini11,
        R.drawable.dini12,
        R.drawable.dini13,
        R.drawable.dini14,
        R.drawable.dini15,
        R.drawable.dini16,
        R.drawable.dini17,
        R.drawable.dini18,
        R.drawable.dini19,
        R.drawable.dini20,
        R.drawable.dini21,
        R.drawable.dini223,
        R.drawable.dini22,
};
    String video_path[]={
		"https://hw1.asset.aparat.com/aparat-video/5506073a79c5eefa956bb7af815fbddd7128289-360p__35461.mp4",

            "https://as10.asset.aparat.com/aparat-video/b49bc09a01a96906ff560388d7dbd0206869526-270p__89307.mp4"
            ,"https://as4.asset.aparat.com/aparat-video/a2a05bb7c1cd15302861894b56be1bf56014690-360p__62928.mp4"

			,"https://as8.asset.aparat.com/aparat-video/81d1c845cbc858154598268f6d9fd9208142218-360p__47499.mp4"
			,"https://as5.asset.aparat.com/aparat-video/d374a30c021314109e50f619f88dda288142425-360p__43762.mp4"
			,"https://as3.asset.aparat.com/aparat-video/afcb94792f2cb4e1fc99b403bccf11048142610-360p__17512.mp4"
			,"https://as10.asset.aparat.com/aparat-video/89a9456e53b412cf583a7e335c9d95428142868-360p__85072.mp4"
			,"https://hw7.asset.aparat.com/aparat-video/badff4399f31442c768405db5957cb548142989-360p__68038.mp4"
			,"https://as7.asset.aparat.com/aparat-video/50d8352e874c427315ead747032374d38143274-360p__11899.mp4"
			,"https://hw3.asset.aparat.com/aparat-video/41cd072dbf267eb4953a2c60dfbde6488152950-360p__67209.mp4"
			,"https://as11.asset.aparat.com/aparat-video/3f411919dc8cda5e9d4da94b86e2a1a88153132-360p__97108.mp4"
			,"https://hw7.asset.aparat.com/aparat-video/8d5d9d15ee81eb61be55210149563f898156172-360p__49266.mp4"
			,"https://hw18.asset.aparat.com/aparat-video/acd73ed3c612a87b18c51d408db864568552836-360p__55499.mp4"
			,"https://as9.asset.aparat.com/aparat-video/2942632c6bdde5469c0ef0829054a9838555443-360p__56044.mp4"
			,"https://hw17.asset.aparat.com/aparat-video/2d6652e0aec9ce9045031777233b02878555881-360p__79173.mp4"
			,"https://as8.asset.aparat.com/aparat-video/7fd2c3abbf778922ef878984dd5161768564544-360p__31301.mp4"
			,"https://as1.asset.aparat.com/aparat-video/6ccaf06e80092b691485052f901d57ce8575598-360p__29473.mp4"
			,"https://as4.asset.aparat.com/aparat-video/805216df83fdb02ee3e936f2549e21cf8577099-360p__33925.mp4"
			,"https://as8.asset.aparat.com/aparat-video/6fd3ce2bbddae6e4fa666b64b84680c18593423-360p__61345.mp4"
			,"https://as2.asset.aparat.com/aparat-video/540c94bc8fb13af599f86101e23d4a318595007-360p__77855.mp4"
			,"https://as1.asset.aparat.com/aparat-video/92d5a5dc3e57f93a2fca7847a720910a8624343-360p__15271.mp4"
			,"https://as10.asset.aparat.com/aparat-video/64160f311b4fb652cf239f63ef19240f8624780-360p__50741.mp4"
			,"https://as4.asset.aparat.com/aparat-video/2bcba71f4ef80563c6e2d4e3664c288f8631085-360p__42273.mp4"
			,"https://hw18.asset.aparat.com/aparat-video/4919b346dafa6bee2605f4767f7ce93e8633033-360p__64232.mp4"
			,"https://as1.asset.aparat.com/aparat-video/6a4e073aee834fb359e506db140882a98649329-360p__40079.mp4"
			,"https://as4.asset.aparat.com/aparat-video/fe087ab1d0d1a9a5731409b82afd18aa8729941-240p__65124.mp4"
			,"https://as4.asset.aparat.com/aparat-video/fe087ab1d0d1a9a5731409b82afd18aa8729941-240p__65124.mp4"
			,"https://hw17.asset.aparat.com/aparat-video/20ad9bc767112d889618af394ac0d0558729980-240p__52565.mp4"
			,"https://as7.asset.aparat.com/aparat-video/ae8924d5629753254adb9d40a0aceb788746639-240p__57204.mp4"
			,"https://as6.asset.aparat.com/aparat-video/96d5d7f1c42585ce072f1a133efae0398754422-240p__14897.mp4"
			,"https://hw18.asset.aparat.com/aparat-video/28953b98ce7cd480637b09e0f68e6c1a8754719-240p__19144.mp4"
			,"https://as3.asset.aparat.com/aparat-video/dfc9c702acfd5a44447afebc6bc179fb8754871-240p__29635.mp4"
			,"https://as9.asset.aparat.com/aparat-video/245fec1df28c3505a8340100fc887d408755257-360p__54296.mp4"
			,"https://as4.asset.aparat.com/aparat-video/1f859ce5401d32501f1309899db694038755405-240p__63593.mp4"
			
			

    };
	int alefba_img []={
		R.drawable.alefba1,R.drawable.alefba2
            ,R.drawable.aa,R.drawable.be,
            R.drawable.pe,R.drawable.te,R.drawable.se,R.drawable.je,R.drawable.che
            ,R.drawable.he2,R.drawable.khe,R.drawable.dal,R.drawable.zal
            ,R.drawable.re,R.drawable.ze,R.drawable.zhe,
            R.drawable.sin,R.drawable.she,R.drawable.sad,
            R.drawable.zad,R.drawable.ta,R.drawable.za,
            R.drawable.aein,R.drawable.ghain,R.drawable.fe,R.drawable.ghaf,
            R.drawable.kaf,R.drawable.gaf,R.drawable.lam,
			R.drawable.mim,R.drawable.noon,R.drawable.vav,
			R.drawable.he,R.drawable.ya
	};

	int parcham_img []={
		R.drawable.afghanestan
            ,R.drawable.arabestan,R.drawable.armanestan,R.drawable.china2,
            R.drawable.englis,R.drawable.farance,R.drawable.ghahereh,R.drawable.ghatar,R.drawable.iragh
            ,R.drawable.iran,R.drawable.italy,R.drawable.jepan
            ,R.drawable.kuvate,R.drawable.lobnan,R.drawable.omman,
            R.drawable.otrish,R.drawable.rus,
            R.drawable.suri,R.drawable.torkamanestan,
			R.drawable.lahestan,R.drawable.yonan,R.drawable.yaman,

	};
	int keshvar_voice[]={R.raw.afghanestan,R.raw.ryaz,R.raw.armanestan,
   R.raw.chin,R.raw.landan,R.raw.faranse,R.raw.mesr,R.raw.ghatar,
   R.raw.aragh,R.raw.iran,R.raw.rom,R.raw.japon,R.raw.kovat,
   R.raw.lobnan,R.raw.omman,R.raw.otrish,
   R.raw.rusiyeh,R.raw.suryeh,R.raw.torkamanestan,R.raw.armanestan,
   R.raw.aten,R.raw.yaman};

    String keshvar_names[]={
            "افغانستان","عربستان","ارمنستان","چین",
            "انگلیس","فرانسه","مصر","قطر",
            "عراق","ایران","ایتالیا","ژاپن",
            "کویت","لبنان","عمان","اتریش",
            "روسیه","سوریه","ترکمنستان","لهستان",
            "یوانان","یمن"

    };
    String videos_amuzeshi_title []={
            "کلیپ میوه","آهنگ نظافت","پاکیزگی دندان",
            "اموزش وسایل نقلیه به کودکان","ترانه فرزندان ایران",
            "شعر رنگها","آموزش فصل ها","شعر زیبای سلام",
            "اعداد فارسی","خانواده انگشت","چوپان دروغگو",
            "حیوانات جنگل"
    };
    String videos_amuzeshi_path []={
           "https://hw1.asset.aparat.com/aparat-video/c18b2bc4e84b4719483825318e43802e7556465-360p__43691.mp4",
            "https://hw1.asset.aparat.com/aparat-video/073d3245ad0976bf5862c2893071e305786607__31407.mp4",
            "https://hw14.asset.aparat.com/aparat-video/e3cab69e1afb75b207b5e3b4aafdc5426662176-360p__76135.mp4",
            "https://hw1.asset.aparat.com/aparat-video/e2cb675a4deaf656a1abb2aa3f1c6e662140791-360p__68916.mp4",
            "https://hw7.asset.aparat.com/aparat-video/d3d4faa53a7251180c873aa4eab7fdb36186971-360p__39226.mp4",
            "https://hw6.asset.aparat.com/aparat-video/d5b428f5360019671685da3814cbcb8c8055934-360p__85151.mp4",
            "https://as9.asset.aparat.com/aparat-video/23ba849c7fb91c04a9facf1b45d9a2905296801-270p__59248.mp4",
            "https://hw7.asset.aparat.com/aparat-video/d1166b3c7d91ba426fc92112dc409f297551798-360p__88652.mp4",
            "https://as2.asset.aparat.com/aparat-video/0be26c87fb7d1e58f00c27fb363c16df7551665-360p__42666.mp4",
            "https://hw2.asset.aparat.com/aparat-video/7d320c14a50bf81e02ef14995e6ac6f16518942-360p__50455.mp4",
            "https://hw2.asset.aparat.com/aparat-video/946de7b91d6b8978ad1c865d64dcb50b6999373-240p__62272.mp4",
            "https://hw3.asset.aparat.com/aparat-video/a9be85949a0788734cf8c4fd81eb7d656292569-360p__19152.mp4",

    };
    int videos_amuzeshi_img []={
            R.drawable.amuzesh_1,
            R.drawable.amuzesh_2,
            R.drawable.amuzesh_3,
            R.drawable.amuzesh_4,
            R.drawable.amuzesh_5,
            R.drawable.amuzesh_6,
            R.drawable.amuzesh_7,
            R.drawable.amuzesh_8,
            R.drawable.amuzesh_9,
            R.drawable.amuzesh_10,
            R.drawable.amuzesh_11,
            R.drawable.amuzesh_12,

    };

    public int get_correct_index(int i){
        return inext_correct[i];
    }
    /*public int get_ostan_img_no_name(int i){
        return img_of_os_no_name[i];
    }*/
    /*public int get_ostan_img(int i){
        return img_of_os[i];
    }*/
    public int get_sound_of_eword(int i){
        return sound_of_ewords[i];
    }
    public int[] get_words_img(){
        return img_of_words;
    }
   /* public int get_q_length(){
        return img_of_os.length;
    }*/
	public int get_voice_of_keshvar(int i){
        int voice_of_keshvar=keshvar_voice[i];
        return  voice_of_keshvar;
    }
    public int get_dini_color(int i){
        int dini_color2=dini_color[i];
        return  dini_color2;
    }

    public String[] get_ostanha(){

        return  ostanha;
    }
    public int[] get_dini_img(){

        return  dini_img;
    }
   /* public int[] get_ostanha_img(){

        return  img_of_os;
    }*/
    public int get_voice_of_ostan(int i){
        int voice_of_ostan=ostan_voice[i];
        return  voice_of_ostan;
    }
    public int get_question_of_center(int i){
        int question_of_center=mquestion_of_center[i];
        return  question_of_center;
    }
    public int get_answer_of_center(int i){
        int answer_of_center=manswer_of_center[i];
        return  answer_of_center;
    }
    public int get_choice1_center(int i){
        int choice1_of_center=choice_question_of_center[i][0];
        return  choice1_of_center;
    }
    public int get_choice2_center(int i){
        int choice2_of_center=choice_question_of_center[i][1];
        return  choice2_of_center;
    }
    public int get_choice3_center(int i){
        int choice3_of_center=choice_question_of_center[i][2];
        return  choice3_of_center;
    }
    public String get_ostan_name(int i){
        String ostan_name=ostanha[i];
        return  ostan_name;
    }
    public String get_video_path(int i){

        return  video_path[i];
    }
    public int[] get_alefba_img(){

        return  alefba_img;
    }
	public int[] get_parcham_img(){

        return  parcham_img;
    }
    public String[] get_keshvar_name(){

        return  keshvar_names;
    }
    public String[] get_dini_video_title(){

        return  dini_video_title;
    }
    public String get_Video_dini_path(int i){

        return  video_dini_path[i];
    }
	/*public int[] get_emam_img(){

        return  img_of_emam;
    }*/
    public String[] get_ewords(){

        return  ewords;
    }
	public int get_sound_of_emam(int i){
        return emam_voice[i];
    }
    public int[] get_sounds_of_emam(){
        return emam_voice;
    }
    public int[] get_sounds_of_keshvar(){
        return keshvar_voice;
    }
    public int[] get_sounds_of_words(){
        return sound_of_ewords;
    }
    public String[] get_amuzeshi_video_title(){
        return  videos_amuzeshi_title;
    }
    public String get_Video_amuzeshi_path(int i){

        return  videos_amuzeshi_path[i];
    }
    public int[] get_video_amuzeshi_img(){

        return  videos_amuzeshi_img;
    }

}
