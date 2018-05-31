package test;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import com.ansj.vec.Learn;
import com.ansj.vec.Word2VEC;
import com.ansj.vec.domain.WordEntry;

public class text_LDA {
	private static final File sportCorpusFile = new File("./YL/train.txt");
    public static void main(String[] args) throws IOException {

       //进行训练（训练一次就行了，因此先注释掉）

     /*   Learn lean = new Learn() ;

        lean.learnFile(sportCorpusFile) ;

        lean.saveModel(new File("vector.mod")) ;
        */


        //加载测试

        Word2VEC w2v = new Word2VEC() ;

        w2v.loadJavaModel("vectorLDA.mod") ;
        //词向量
     //   float[] tmpValue = w2v.getWordVector("手机");
      
      //  System.out.println(tmpValue);
     
        //近义词，默认是20个
        System.out.println(w2v.distance("卡西欧"));
        
        //Set<WordEntry> set = w2v.distance("笔记本电脑");
        
        
       
     /*   ArrayList<String> testSets = new ArrayList<String>();
        testSets.add("祖国/n");
        testSets.add("坚持/v");
        testSets.add("北京/ns");
        //近义词，默认是40个
        System.out.println(w2v.distance("祖国/n"));
        //加减运算  wordVector[i] = wv1[i] - wv0[i] + wv2[i];
        System.out.println(w2v.analogy("今晚/t", "上午/t", "今天/t"));*/
    }

}
