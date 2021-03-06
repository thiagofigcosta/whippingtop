package br.cefetmg.move2play.whippingtop.util;

import com.badlogic.gdx.math.Vector3;
import br.cefetmg.move2play.whippingtop.util.files.Models;
import br.cefetmg.move2play.whippingtop.util.files.Textures;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.math.Vector2;
import java.util.Random;


public class Util {
    public static final double OFFSET=0.00001;
    
    public static boolean offsetEqual(double a, double b, double offset){
        offset=Math.abs(offset);
        return a+offset>=b&&a-offset<=b;
    }
    
    public static boolean offsetEqual(double a, double b){
        return offsetEqual(a,b,OFFSET);
    }
    
    public static double compareSpeed(double expected,double achieved){
        double percent=Math.abs(expected-achieved)/expected;
        return percent;
    }
    
    public static double modAngle(double angle,double increase ,double max, double min){
        if(angle+increase>max){
            angle=max;
        }else if(angle+increase<min){
            angle=min;
        }else{
            angle+=increase;
        }
        return angle;
    }
    
    public static String genCone(){
        Random rand = new Random();
        switch(rand.nextInt(5)){
            default:return Models.Cone0();
            case 1 :return Models.Cone1();
            case 2 :return Models.Cone2();
            case 3 :return Models.Cone3();
            case 4 :return Models.Cone4();
            case 5 :return Models.Cone5();
        }
    }
    
    public static String genBridge(){
        Random rand = new Random();
        switch(rand.nextInt(5)){
            default: return Textures.Bridge0();
            case 1: return Textures.Bridge1();
            case 2: return Textures.Bridge2();
            case 3: return Textures.Bridge3();
            case 4: return Textures.Bridge4();
        }
    }
    
    public static int genInt(int max){
        Random rand = new Random();
        return rand.nextInt(max);
    }
    
    public static Vector3 vec3Sub(Vector3 a,Vector3 b){
        return new Vector3(a.x-b.x,a.y-b.y,a.z-b.z);
    }
    public static Vector3 vec3Mult(Vector3 a, float b){
        return new Vector3(a.x*b,a.y*b,a.z*b);
    }
    
    public static BitmapFont createBitMapFromTTF(String ttfpath, Color color, int size, Color bordercolor, int borderSize){
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(ttfpath));
        FreeTypeFontParameter parameter = new FreeTypeFontParameter();
        parameter.size=size;
        parameter.color=color;
        parameter.borderColor=bordercolor;
        parameter.borderWidth=borderSize;
        BitmapFont font = generator.generateFont(parameter);
        return font;
    }
    
    public static BitmapFont createBitMapFromTTF(String ttfpath, Color color){
        return createBitMapFromTTF(ttfpath, color, 15, Color.BLACK, 0);
    }
    
    public static BitmapFont createBitMapFromTTF(String ttfpath, Color color, int size){
        return createBitMapFromTTF(ttfpath, color, size, Color.BLACK, 0);
    }
    
    public static void drawCenteredText(String text,Vector2 pos,BitmapFont font, SpriteBatch batch){
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(font,text);
        float textSizeX=glyphLayout.width/2;
        float textSizeY=glyphLayout.height/2;
        batch.begin();
        font.draw(batch,text, pos.x-textSizeX, pos.y+textSizeY);
        batch.end();
    }
    
    public static Color byteToColor(byte[] in){
        Color out=new Color(0,0,0,1);
        out.r=(int)(in[0]+128)/255f;
        out.g=(int)(in[1]+128)/255f;
        out.b=(int)(in[2]+128)/255f;
        return out;
    }
    
    
    public static byte[] colorToByte(Color in){
        byte[] out=new byte[3];
        out[0]=(byte) (in.r*255);
        out[1]=(byte) (in.g*255);
        out[2]=(byte) (in.g*255);
        return out;
    }
}
