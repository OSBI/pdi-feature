package bi.meteorite;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.util.EnvUtil;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;

/**
 * Created by bugg on 13/01/16.
 */
public class PdiTest {

  public PdiTest() {

     }

  public void bootstrap(){
    try {
      KettleEnvironment.init();


      //StepLoader.init();
      EnvUtil.environmentInit();
      TransMeta transMeta = new TransMeta("/tmp/t1.ktr");
      Trans trans = new Trans(transMeta);

      trans.execute(null); // You can pass arguments instead of null.
      trans.waitUntilFinished();
      if ( trans.getErrors() > 0 )
      {
        throw new RuntimeException( "There were errors during transformation execution." );
      }
    }
    catch ( Exception e ) {
      // TODO Put your exception-handling code here.
      System.out.println(e);
    }


  }

}
