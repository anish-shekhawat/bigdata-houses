package Houses;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import java.io.IOException;
import java.text.DecimalFormat;

public class HousesReducer  extends Reducer <Text,IntWritable,Text,FloatWritable> {

	public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

        // initialize min and max values

        int min = values.iterator().next().get(), max=0, count=0;
        float sum = 0, mean=0;
        
	sum += min;
	count++;

	// loop through values to determine min, max, count, and sum
        for (IntWritable value:values)
        {
    	    // System.out.println("Value: " + value);
            
	    sum += value.get();

            if (value.get() > max)
            {
                max = value.get();
            }

            if (value.get()<min)
            {
                min = value.get();
            }
            count++;
        }

    	// System.out.println("Sum: " + sum + "Count: " + count);
	// calculate mean
        mean = sum / count;
	
	// write (key, min) to context
        context.write(key,new FloatWritable(min));
	// write (key, mean) to context
        context.write(key, new FloatWritable(mean));
	// write (key, max) to context
        context.write(key, new FloatWritable(max));
    }
}
