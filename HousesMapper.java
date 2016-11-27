package Houses;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.StringTokenizer;

public class HousesMapper  extends Mapper <LongWritable,Text,Text,IntWritable> {
	private static Log log = LogFactory.getLog(HousesMapper.class);

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String neighbourhood="", priceString;
        int price=0;

        // skip very first record (schema line)
        if(key.get() ==  0)
        {
            return;
        }

        // create iterator over record assuming comma-separated fields
        StringTokenizer iterator = new   StringTokenizer(value.toString(),"\\,");

  	// validate number of tokens in iterator
        if(iterator.countTokens()!=81)
        {
            log.info("No. of tokens is invalid");
        }

    	// get neighborhodd
        for(int i=0; i<81; i++)
        {
            if(i==12)
            {
                neighbourhood = iterator.nextToken();

                // if empty or null, then write a message to log
                if(neighbourhood == null || neighbourhood.isEmpty())
                {
                    log.info("Token Neighbourhood is Empty or Null!");
                }

            } else if(i==80)
            {
            	// get price
                priceString = 	iterator.nextToken();

                // convert price to int
                price =  Integer.parseInt(priceString);

                // validate the price is greater than zero
                if(price<0)
                {
            		// if price <= 0, then write a message to log
        		log.info("Price is less than zero!!");
                    	return;
                }

            }
            else
            {
                iterator.nextToken();
            }
        }

 	// emit key-value as (neighborhood, price)
        context.write(new Text(neighbourhood),new IntWritable(price));
    }
}
