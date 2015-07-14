package main
/**
 * Connect to HBase
 */

import org.apache.commons.configuration.BaseConfiguration
import com.thinkaurelius.titan.core._


// import com.tinkerpop.blueprints._
// import com.tinkerpop.blueprints.impls.tg.TinkerGraph
// import com.thinkaurelius.titan.core._
// import com.tinkerpop.blueprints._
// import com.tinkerpop.blueprints.{Graph,Vertex,Edge,Direction}
// import com.tinkerpop.blueprints.Direction._
// import com.tinkerpop.rexster.client.{RexsterClientFactory,RexsterClient}
// import scala.collection.JavaConverters._


object Huehuecoyotl {
  /**
   * Trickster God
   * The name "Very old coyote" conveyed positive meanings for the Aztec
   * populace; coyotes were an Aztec symbol of astuteness and worldly-wisdom,
   * pragmatism and male beauty and youthfulness. The prefix "huehue" which
   * in Nahuatl means "very old" was attached to gods in Aztec mythology that
   * were revered for their old age, wisdom, philosophical insights and
   * connections to the divine.
   */

  /**
   * Main Function
   * 1. Parse command line
   * 2. Connect to titan db
   * 3. Attempt erase
   * 4. Attempt write
   * 5. Attempt read
   * 6. Close
   */
  def main(args: Array[String]) = {

    /** Simple check argument numbers match **/
    if (args.length != 3) {
      println("ERROR: Command line does not contain enough parameters")
    }

    /**
     * 1. Parse command line
     * HOST: String
     * PORT: Integer
     * CONF: Apache base configuration
     */
    val HOST = args(0)
    val PORT = args(1).toInt
    val CONF = new BaseConfiguration();
    CONF setProperty("storage.backend", "hbase")
    // CONF setProperty("storage.hostname", HOST)

    /**
     * Display configuration
     */
    println(s"HOST .... $HOST")
    println(s"PORT .... $PORT")

    /** 2. Connect to titan DB */
    val graph = TitanFactory open(CONF)
    println("Connected.")

    /** 6. Close **/
    graph.shutdown
    println("Shut down.")
  }
}
