package madsum.resume;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class displayResume extends Activity {

    TextView tkeScr;
    Bitmap bitmap;
    Button genFile;

    TextView dName, dAddr, dContact, dMailid, dCareerobj, dEduqua1, dEduqua2, dEduqua3, dPos, dWorkexp,
            dSkills, dInterests, dDob, dNati, dMarit, dLang, dRef, dAge;

    public static final String mypreference = "mypref";
    public static final String TAG_Name = "NameKey";
    public static final String TAG_Addr = "AddrKey";
    public static final String TAG_Contact = "ContactKey";
    public static final String TAG_Mailid = "MailidKey";
    public static final String TAG_Careerobj = "CareerObj";
    public static final String TAG_Eduqua1 = "Eduqua1Key";
    public static final String TAG_Eduqua2 = "Eduqua2Key";
    public static final String TAG_Eduqua3 = "Eduqua3Key";
    public static final String TAG_Pos = "PosKey";
    public static final String TAG_Workexp = "WorkexpKey";
    public static final String TAG_Skills = "SkillsKey";
    public static final String TAG_Interests = "InterestsKey";
    public static final String TAG_Dob = "DobKey";
    public static final String TAG_Nati = "NatiKey";
    public static final String TAG_Marit = "MaritKey";
    public static final String TAG_Lang = "LangKey";
    public static final String TAG_Ref = "RefKey";
    public static final String TAG_Age = "AgeKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_resume);

        dName = (TextView) findViewById(R.id.textView41);
        dAddr = (TextView) findViewById(R.id.textView42);
        dContact = (TextView) findViewById(R.id.textView43);
        dMailid = (TextView) findViewById(R.id.textView44);
        dCareerobj = (TextView) findViewById(R.id.textView46);
        dEduqua1 = (TextView) findViewById(R.id.textView48);
        dEduqua2 = (TextView) findViewById(R.id.textView49);
        dEduqua3 = (TextView) findViewById(R.id.textView50);
        dPos = (TextView) findViewById(R.id.textView52);
        dWorkexp = (TextView) findViewById(R.id.textView54);
        dSkills = (TextView) findViewById(R.id.textView56);
        dInterests = (TextView) findViewById(R.id.textView58);
        dDob = (TextView) findViewById(R.id.textView60);
        dNati = (TextView) findViewById(R.id.textView61);
        dMarit = (TextView) findViewById(R.id.textView62);
        dLang = (TextView) findViewById(R.id.textView63);
        dRef = (TextView) findViewById(R.id.textView66);
        dAge = (TextView) findViewById(R.id.textView64);

        tkeScr = (TextView) findViewById(R.id.textView40);
       // genFile = (Button) findViewById(R.id.gen_file_button);

        String disName = getIntent().getStringExtra(TAG_Name);
        String disAddr = getIntent().getStringExtra(TAG_Addr);
        String disContact = getIntent().getStringExtra(TAG_Contact);
        String disMailid = getIntent().getStringExtra(TAG_Mailid);
        String disCareerobj = getIntent().getStringExtra(TAG_Careerobj);
        String disEququa1 = getIntent().getStringExtra(TAG_Eduqua1);
        String disEduqua2 = getIntent().getStringExtra(TAG_Eduqua2);
        String disEduqua3 = getIntent().getStringExtra(TAG_Eduqua3);
        String disPos = getIntent().getStringExtra(TAG_Pos);
        String disWorkexp = getIntent().getStringExtra(TAG_Workexp);
        String disSkills = getIntent().getStringExtra(TAG_Skills);
        String disInterests = getIntent().getStringExtra(TAG_Interests);
        String disDob = getIntent().getStringExtra(TAG_Dob);
        String disNati = getIntent().getStringExtra(TAG_Nati);
        String disMarit = getIntent().getStringExtra(TAG_Marit);
        String disLang = getIntent().getStringExtra(TAG_Lang);
        String disRef = getIntent().getStringExtra(TAG_Ref);
        String disAge = getIntent().getStringExtra(TAG_Age);

        dName.setText(disName);
        dAddr.setText(disAddr);
        dContact.setText(disContact);
        dMailid.setText(disMailid);
        dCareerobj.setText(disCareerobj);
        dEduqua1.setText(disEququa1);
        dEduqua2.setText(disEduqua2);
        dEduqua3.setText(disEduqua3);
        dPos.setText(disPos);
        dWorkexp.setText(disWorkexp);
        dSkills.setText(disSkills);
        dInterests.setText(disInterests);
        dDob.setText("Date of Birth:-  " + disDob);
        dNati.setText("Nationality:-  " + disNati);
        dMarit.setText("Marital Status:-  " + disMarit);
        dLang.setText("languages Known:-  " + disLang);
        dRef.setText(disRef);
        dAge.setText("Age:-  " + disAge);

        tkeScr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //final RelativeLayout layout = (RelativeLayout) findViewById(R.id.relativelayoutdResume);
                final View v = findViewById(android.R.id.content).getRootView();
                v.setDrawingCacheEnabled(true);
                v.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
                v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());

                v.post(new Runnable() {
                    @Override
                    public void run() {
                        Bitmap pic = takeScreenShot(v);
                        try{
                            if(pic != null){
                                saveScreenShot(pic);
                                Toast.makeText(getApplicationContext(), "Screenshot saved in the memory by the name resume.png !", Toast.LENGTH_LONG).show();
                            }

                        }catch(Exception e){
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),"Error while generating the screenshot !", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

    }

    // Take Screenshot
    private Bitmap takeScreenShot(View v) {


        Bitmap screenShot = null;

        try {
            int width = v.getMeasuredWidth();
            int height = v.getMeasuredHeight();

            screenShot = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

            //Draw to Canvas

            Canvas c = new Canvas(screenShot);
            v.draw(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return screenShot;

    }

    //Save  the screenshot to external memory
    private void saveScreenShot(Bitmap bm) {
        ByteArrayOutputStream bao = null;
        File file = null;

        try{
            //compresss and write to output stream
            bao= new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.PNG, 100, bao);

            // write as a file to sd card
            file = new File(Environment.getExternalStorageDirectory()+ File.separator+"resume.png");
            file.createNewFile();

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bao.toByteArray());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }



/*       tkeScr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bitmap = getScreenBitmap();
                saveTheBitmap(bitmap);
            }
        });
    }

    public Bitmap getScreenBitmap() {
        View v = findViewById(android.R.id.content).getRootView();
        v.setDrawingCacheEnabled(true);
        v.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());

        v.buildDrawingCache(true);
        //Bitmap bitmap = Bitmap.createBitmap(v.getDrawingCache());
        v.setDrawingCacheEnabled(true); // clear drawing cache
        return v.getDrawingCache();
    }

    public void saveTheBitmap(Bitmap bitmap)
    {
        File imagePath = new File(Environment.getExternalStorageDirectory() + "/screenshot.png");
        FileOutputStream fos;
        try
        {
            fos = new FileOutputStream(imagePath);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
        }
        catch (FileNotFoundException e)
        {
            Log.e("GREC", e.getMessage(), e);
        }
        catch (Exception e)
        {
            Log.e("GREC", e.getMessage(), e);
        }
    }
}

*/

        // Another code to take the screenshot.



    /*

}*/
