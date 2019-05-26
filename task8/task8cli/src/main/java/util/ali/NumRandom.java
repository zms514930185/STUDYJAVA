package util.ali;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumRandom {

    public String randNum(){
        Random random = new Random();
        String result="";
        for (int i=0;i<6;i++)
        {
            result+=random.nextInt(10);
        }
        return result;
    }

}
