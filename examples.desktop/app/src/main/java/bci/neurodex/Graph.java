package bci.neurodex;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by suryo on 23/5/15.
 */
public class Graph extends Activity {

    int currentAttention;
    int count = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph_layout);

        readFile();
    }



    //public void readFile(View v) {

    public void readFile() {
        File sdCard = Environment.getExternalStorageDirectory();
        File dir = new File (sdCard.getAbsolutePath() + "/synapse/");


        File file = new File(dir,"filename");

        StringBuilder text = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            GraphView progressGraph = (GraphView) findViewById(R.id.graph);

            Toast.makeText(getApplicationContext(), "ID of Graph is made", Toast.LENGTH_SHORT).show();
            while ((line = br.readLine()) != null) {
                currentAttention = Integer.parseInt(line);
                count++;
                text.append(line);
                text.append('\n');


//                String string1 = new Integer(foo).toString();
//                TextView tv = (TextView)findViewById(R.id.indicator);
//                tv.setText(string1);


            }

            Toast.makeText(getApplicationContext(), "count is" + count, Toast.LENGTH_SHORT).show();
            int[] attn = new int[count];

            Toast.makeText(getApplicationContext(), "Array declared", Toast.LENGTH_SHORT).show();
            int i = 0;
            int n = count;
//
//            DataPoint[] arr1 = new DataPoint[n];
//


            BufferedReader br1 = new BufferedReader(new FileReader(file));
            String line1;

            while (((line1 = br1.readLine()) != null)&&(i<n)) {
                currentAttention = Integer.parseInt(line1);
                attn[i] = currentAttention;
                i++;

            }
            Toast.makeText(getApplicationContext(), "Array initialized", Toast.LENGTH_SHORT).show();

            i = 0;
            DataPoint arr1[] = new DataPoint[n];

            while(i<n)
            {
                arr1[i] = new DataPoint(i,attn[i]);
                i++;
            }

            LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(arr1);
            progressGraph.addSeries(series);

//
//
//            while ((line = br.readLine()) != null) {
//                currentAttention = Integer.parseInt(line);
//                arr1[i++] = new DataPoint(i,currentAttention);
//                //text.append(line);
//                //text.append('\n');
//                //System.out.println(foo);
//                //Toast.makeText(getApplicationContext(), foo, Toast.LENGTH_SHORT).show();
//
//                //String string1 = new Integer(foo).toString();
//                //TextView tv = (TextView)findViewById(R.id.indicator);
//                //tv.setText(string1);
//
//
//            }
//
//            LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(arr1);
//            progressGraph.addSeries(series);
//
//                while ((line = br.readLine()) != null) {
//                    currentAttention = Integer.parseInt(line);
//                    count++;
//                    text.append(line);
//                    text.append('\n');
//                    //System.out.println(foo);
//                    //Toast.makeText(getApplicationContext(), foo, Toast.LENGTH_SHORT).show();
//
//                    //String string1 = new Integer(foo).toString();
//                    //TextView tv = (TextView)findViewById(R.id.indicator);
//                    //tv.setText(string1);
//
//
//                }
//            });
//
//            while ((line = br.readLine()) != null) {
//                currentAttention = Integer.parseInt(line);
//                count++;
//                text.append(line);
//                text.append('\n');
//                //System.out.println(foo);
//                //Toast.makeText(getApplicationContext(), foo, Toast.LENGTH_SHORT).show();
//
//                //String string1 = new Integer(foo).toString();
//                //TextView tv = (TextView)findViewById(R.id.indicator);
//                //tv.setText(string1);
//
//
//            }
            br.close();
            br1.close();
        }
        catch (IOException e) {
            //You'll need to add proper error handling here
        }

//Find the view by its id
        //TextView tv = (TextView)findViewById(R.id.indicator);

//Set the text
        //tv.setText(text);

    }

}
