package madsum.resume;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity2 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView biodata;
    static final int CAM_REQUEST = 1;
    private final int SELECT_PHOTO = 1;
    private ImageView imageView2;
    private ImageView imageViewBtnPick;
    TextView name;
    TextView degree, college, pos, dob, age, workexp, skills, interests, contact, mailid, careerobj,
            addr, eduqua1, eduqua2,eduqua3, nati, marit, lang, ref;
    SharedPreferences sharedPreferences;



    public static final String mypreference = "mypref";
    public static final String Name = "NameKey";
    public static final String Degree = "DegreeKey";
    public static final String College = "CollegeKey";
    public static final String Pos = "PosKey";
    public static final String Dob = "DobKey";
    public static final String Age = "AgeKey";
    public static final String Workexp = "WorkexpKey";
    public static final String Skills = "SkillsKey";
    public static final String Interests = "InterestsKey";
    public static final String Contact = "ContactKey";
    public static final String Mailid = "MailidKey";
    public static final String Careerobj = "CareerObj";
    public static final String Addr = "AddrKey";
    public static final String Eduqua1 ="Eduqua1Key";
    public static final String Eduqua2 ="Eduqua2Key";
    public static final String Eduqua3="Eduqua3Key";
    public static final String Nati ="NatiKey";
    public static final String Marit = "MaritKey";
    public static final String Lang = "LangKey";
    public static final String Ref = "RefKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // shared preferences
        name = (TextView)findViewById(R.id.textView5);
        degree = (TextView)findViewById(R.id.textView6);
        college = (TextView)findViewById(R.id.textView7);
        pos = (TextView)findViewById(R.id.textView8);
        dob = (TextView)findViewById(R.id.textView9);
        age = (TextView)findViewById(R.id.textView10);
        workexp = (TextView)findViewById(R.id.textView11);
        skills = (TextView)findViewById(R.id.textView12);
        interests = (TextView)findViewById(R.id.textView13);
        contact = (TextView)findViewById(R.id.textView14);
        mailid = (TextView)findViewById(R.id.textView15);
        careerobj = (TextView) findViewById(R.id.textView16);
        addr = (TextView) findViewById(R.id.textView17);
        eduqua1 = (TextView) findViewById(R.id.textView18);
        eduqua2=(TextView) findViewById(R.id.textView19);
        eduqua3 = (TextView) findViewById(R.id.textView20);
        nati = (TextView) findViewById(R.id.textView21);
        marit = (TextView) findViewById(R.id.textView22);
        lang = (TextView) findViewById(R.id.textView23);
        ref = (TextView) findViewById(R.id.textView24);

        sharedPreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        if (sharedPreferences.contains(Name)) {
            name.setText(sharedPreferences.getString(Name, ""));
        }
        if (sharedPreferences.contains(Degree)) {
            degree.setText(sharedPreferences.getString(Degree, ""));

        }
        if(sharedPreferences.contains(College)) {
            college.setText(sharedPreferences.getString(College, ""));
        }
        if(sharedPreferences.contains(Pos)) {
            pos.setText(sharedPreferences.getString(Pos, ""));
        }
        if(sharedPreferences.contains(Dob)) {
            dob.setText(sharedPreferences.getString(Dob, ""));
        }
        if(sharedPreferences.contains(Age)) {
            age.setText(sharedPreferences.getString(Age, ""));
        }
        if(sharedPreferences.contains(Workexp)) {
            workexp.setText(sharedPreferences.getString(Workexp, ""));
        }
        if(sharedPreferences.contains(Skills)) {
            skills.setText(sharedPreferences.getString(Skills, ""));
        }
        if(sharedPreferences.contains(Interests)) {
            interests.setText(sharedPreferences.getString(Interests, ""));
        }
        if(sharedPreferences.contains(Contact)) {
            contact.setText(sharedPreferences.getString(Contact, ""));
        }
        if(sharedPreferences.contains(Mailid)) {
            mailid.setText(sharedPreferences.getString(Mailid, ""));
        }
        if(sharedPreferences.contains(Careerobj)) {
            careerobj.setText(sharedPreferences.getString(Careerobj, ""));
        }
        if(sharedPreferences.contains(Addr)) {
            addr.setText(sharedPreferences.getString(Addr, ""));
        }
        if(sharedPreferences.contains(Eduqua1)){
            eduqua1.setText(sharedPreferences.getString(Eduqua1,""));
        }
        if(sharedPreferences.contains(Eduqua2)){
            eduqua2.setText(sharedPreferences.getString(Eduqua2,""));
        }
        if(sharedPreferences.contains(Eduqua3)){
            eduqua3.setText(sharedPreferences.getString(Eduqua3,""));
        }
        if(sharedPreferences.contains(Nati)){
            nati.setText(sharedPreferences.getString(Nati,""));
        }
        if(sharedPreferences.contains(Marit)){
            marit.setText(sharedPreferences.getString(Marit,""));
        }
        if(sharedPreferences.contains(Lang)){
            lang.setText(sharedPreferences.getString(Lang,""));
        }
        if(sharedPreferences.contains((Ref))){
            ref.setText(sharedPreferences.getString(Ref, ""));
        }


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        biodata = (TextView) findViewById(R.id.textView4);
        Typeface face = Typeface.createFromAsset(getAssets(), "font/SupercellFont.ttf");
        biodata.setTypeface(face, Typeface.BOLD);

        imageView2 = (ImageView)findViewById(R.id.imageView2);

        imageViewBtnPick = (ImageView)findViewById(R.id.imageView3);

    }

    public void onClickSave(View view) {

        String n = name.getText().toString();
        String de = degree.getText().toString();
        String c = college.getText().toString();
        String p = pos.getText().toString();
        String d = dob.getText().toString();
        String a = age.getText().toString();
        String w = workexp.getText().toString();
        String s = skills.getText().toString();
        String i = interests.getText().toString();
        String co = contact.getText().toString();
        String m = mailid.getText().toString();
        String caro = careerobj.getText().toString();
        String ad = addr.getText().toString();
        String eq1 = eduqua1.getText().toString();
        String eq2 = eduqua2.getText().toString();
        String eq3 = eduqua3.getText().toString();
        String nation = nati.getText().toString();
        String mar = marit.getText().toString();
        String la = lang.getText().toString();
        String re = ref.getText().toString();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Name, n);
        editor.putString(Degree, de);
        editor.putString(College, c);
        editor.putString(Pos, p);
        editor.putString(Dob, d);
        editor.putString(Age, a);
        editor.putString(Workexp, w);
        editor.putString(Skills, s);
        editor.putString(Interests, i);
        editor.putString(Contact, co);
        editor.putString(Mailid, m);
        editor.putString(Careerobj, caro);
        editor.putString(Addr, ad);
        editor.putString(Eduqua1, eq1);
        editor.putString(Eduqua2, eq2);
        editor.putString(Eduqua3, eq3);
        editor.putString(Nati, nation);
        editor.putString(Marit, mar);
        editor.putString(Lang, la);
        editor.putString(Ref, re);

        editor.commit();

        Toast.makeText(getApplicationContext(), "Thanks ! Info Saved !", Toast.LENGTH_LONG).show();

    }

    public void onClickGet(View view) {
        name = (TextView)findViewById(R.id.textView5);
        degree = (TextView)findViewById(R.id.textView6);
        college = (TextView)findViewById(R.id.textView7);
        pos = (TextView)findViewById(R.id.textView8);
        dob = (TextView)findViewById(R.id.textView9);
        age = (TextView)findViewById(R.id.textView10);
        workexp = (TextView)findViewById(R.id.textView11);
        skills = (TextView)findViewById(R.id.textView12);
        interests = (TextView)findViewById(R.id.textView13);
        contact = (TextView)findViewById(R.id.textView14);
        mailid=(TextView)findViewById(R.id.textView15);
        careerobj = (TextView) findViewById(R.id.textView16);
        addr = (TextView) findViewById(R.id.textView17);
        eduqua1=(TextView) findViewById(R.id.textView18);
        eduqua2=(TextView) findViewById(R.id.textView19);
        eduqua3=(TextView) findViewById(R.id.textView20);
        nati = (TextView) findViewById(R.id.textView21);
        marit= (TextView) findViewById(R.id.textView22);
        lang = (TextView) findViewById(R.id.textView23);
        ref = (TextView) findViewById(R.id.textView24);
        sharedPreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        if (sharedPreferences.contains(Name)) {
            name.setText(sharedPreferences.getString(Name, ""));
        }
        if (sharedPreferences.contains(Degree)) {
            degree.setText(sharedPreferences.getString(Degree, ""));
        }
        if(sharedPreferences.contains(College)) {
            college.setText(sharedPreferences.getString(College, ""));
        }
        if(sharedPreferences.contains(Pos)) {
            pos.setText(sharedPreferences.getString(Pos, ""));
        }
        if(sharedPreferences.contains(Dob)) {
            dob.setText(sharedPreferences.getString(Dob, ""));
        }
        if(sharedPreferences.contains(Age)) {
            age.setText(sharedPreferences.getString(Age, ""));
        }
        if(sharedPreferences.contains(Workexp)) {
            workexp.setText(sharedPreferences.getString(Workexp, ""));
        }
        if(sharedPreferences.contains(Skills)) {
            skills.setText(sharedPreferences.getString(Skills, ""));
        }
        if(sharedPreferences.contains(Interests)) {
            interests.setText(sharedPreferences.getString(Interests, ""));
        }
        if(sharedPreferences.contains(Contact)) {
            contact.setText(sharedPreferences.getString(Contact, ""));
        }
        if(sharedPreferences.contains(Mailid)) {
            mailid.setText(sharedPreferences.getString(Mailid, ""));
        }
        if(sharedPreferences.contains(Careerobj)){
            careerobj.setText(sharedPreferences.getString(Careerobj, ""));
        }
        if(sharedPreferences.contains(Addr)) {
            addr.setText(sharedPreferences.getString(Addr, ""));
        }
        if(sharedPreferences.contains(Eduqua1)){
            eduqua1.setText(sharedPreferences.getString(Eduqua1,""));
        }
        if(sharedPreferences.contains(Eduqua2)){
            eduqua2.setText(sharedPreferences.getString(Eduqua2,""));
        }
        if(sharedPreferences.contains(Eduqua3)){
            eduqua3.setText(sharedPreferences.getString(Eduqua3,""));
        }
        if(sharedPreferences.contains(Nati)){
            nati.setText(sharedPreferences.getString(Nati,""));
        }
        if(sharedPreferences.contains(Marit)){
            marit.setText(sharedPreferences.getString(Marit, ""));
        }
        if(sharedPreferences.contains(Lang)){
            lang.setText(sharedPreferences.getString(Lang, ""));
        }
        if(sharedPreferences.contains(Ref)){
            ref.setText(sharedPreferences.getString(Ref, ""));
        }

        Toast.makeText(getApplicationContext(), "Displaying Info !", Toast.LENGTH_LONG).show();

    }

    public void onClickClear(View view) {
        name = (TextView)findViewById(R.id.textView5);
        degree = (TextView)findViewById(R.id.textView6);
        college = (TextView)findViewById(R.id.textView7);
        pos = (TextView)findViewById(R.id.textView8);
        dob = (TextView)findViewById(R.id.textView9);
        age = (TextView)findViewById(R.id.textView10);
        workexp = (TextView)findViewById(R.id.textView11);
        skills = (TextView)findViewById(R.id.textView12);
        interests = (TextView)findViewById(R.id.textView13);
        contact = (TextView)findViewById(R.id.textView14);
        mailid=(TextView)findViewById(R.id.textView15);
        careerobj = (TextView) findViewById(R.id.textView16);
        addr = (TextView) findViewById(R.id.textView17);
        eduqua1 = (TextView) findViewById(R.id.textView18);
        eduqua2 = (TextView) findViewById(R.id.textView19);
        eduqua3=(TextView) findViewById(R.id.textView20);
        nati=(TextView) findViewById(R.id.textView21);
        marit = (TextView) findViewById(R.id.textView22);
        lang = (TextView) findViewById(R.id.textView23);
        ref= (TextView) findViewById(R.id.textView24);

        name.setText("");
        degree.setText("");
        college.setText("");
        pos.setText("");
        dob.setText("");
        age.setText("");
        workexp.setText("");
        skills.setText("");
        interests.setText("");
        contact.setText("");
        mailid.setText("");
        careerobj.setText("");
        addr.setText("");
        eduqua1.setText("");
        eduqua2.setText("");
        eduqua3.setText("");
        nati.setText("");
        marit.setText("");
        lang.setText("");
        ref.setText("");
        Toast.makeText(getApplicationContext(), "Info Cleared !", Toast.LENGTH_LONG).show();

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void openPdf(View view) {

        // code to open a pdf file in app starts

        File file = new File(Environment.getExternalStorageDirectory().
                getAbsolutePath() +"/" + "Resume");
        Intent target = new Intent(Intent.ACTION_VIEW);
        target.setDataAndType(Uri.fromFile(file), "application/pdf");
        target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        Intent intent = Intent.createChooser(target, "Open File");
        try {startActivity(intent);}
        catch (ActivityNotFoundException e) {
        }
       // code to open a pdf file ends

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //no inspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(MainActivity2.this, MailActivity.class);
            startActivity(i);
            return true;
        }

        if(id== R.id.action_mail){
            Intent i = new Intent(MainActivity2.this, MailActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

            Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            File file = getFile();
            camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
            startActivityForResult(camera_intent, CAM_REQUEST);

        }

        else if (id == R.id.nav_gallery) {
            Toast.makeText(getApplicationContext(), "Go Pro to avail this functionality !", Toast.LENGTH_LONG).show();
        }

        else if (id == R.id.nav_slideshow) {
            Intent galleryIntent = new Intent(MainActivity2.this, CameraGallery.class);
            startActivity(galleryIntent);
        }

        else if (id == R.id.nav_manage) {

        }

        else if (id == R.id.nav_share) {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Here is the share content body";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));

        }

        else if (id == R.id.nav_rate) {

            final String appPackageName = getPackageName();
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName)));
            }

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private File getFile () {
        File folder = new File("sdcard/camera_app");

        if (!folder.exists()) {
            folder.mkdir();
        }
        String newName = String.format("%d.jpg", System.currentTimeMillis());
        File filename = new File(folder, newName);
        return filename;
    }

    //code to select and display a image in image view starts----->>>>

    public void onClickCh(View view) {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, SELECT_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch(requestCode) {
            case SELECT_PHOTO:
                if(resultCode == RESULT_OK){
                    try {
                        final Uri imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        imageView2.setImageBitmap(selectedImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

    //code to select and display a image in image view ends------>>>>>

    public void onClickViewResume(View view) {

        Intent actt = new Intent(MainActivity2.this, displayResume.class);

        actt.putExtra(Name, name.getText().toString());
        actt.putExtra(Addr, addr.getText().toString());
        actt.putExtra(Contact , contact.getText().toString());
        actt.putExtra(Mailid , mailid.getText().toString());
        actt.putExtra(Careerobj, careerobj.getText().toString());
        actt.putExtra(Eduqua1, eduqua1.getText().toString());
        actt.putExtra(Eduqua2, eduqua2.getText().toString());
        actt.putExtra(Eduqua3, eduqua3.getText().toString());
        actt.putExtra(Pos, pos.getText().toString());
        actt.putExtra(Workexp, workexp.getText().toString());
        actt.putExtra(Skills, skills.getText().toString());
        actt.putExtra(Interests, interests.getText().toString());
        actt.putExtra(Dob, dob.getText().toString());
        actt.putExtra(Nati, nati.getText().toString());
        actt.putExtra(Marit, marit.getText().toString());
        actt.putExtra(Lang, lang.getText().toString());
        actt.putExtra(Ref, ref.getText().toString());
        actt.putExtra(Age, age.getText().toString());
        startActivity(actt);

    }

    /*public static boolean isEmailValid(String mailid){
        boolean isValid= false;
        String expresssion = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = mailid;
        Pattern pattern = Pattern.compile(expresssion, Pattern.CASE_INSENSITIVE);
        Matcher matcher= pattern.matcher(inputStr);
        if(matcher.matches()){
            isValid=true;
        }
        return isValid;
    }*/

    public void onClickGenPdf(View view){
        Intent intent = new Intent(MainActivity2.this, displayResume.class);
        startActivity(intent);


    }
}
