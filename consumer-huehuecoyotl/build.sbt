name := "huehuecoyotl"
version := "0.0.0"
scalaVersion := "2.11.1"

libraryDependencies += "com.thinkaurelius.titan" % "titan-core" % "0.5.4"
libraryDependencies += "com.thinkaurelius.titan" % "titan-hbase" % "0.5.4"
libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"

// Maybe we don't need these
// libraryDependencies += "com.thinkaurelius.titan" % "titan-rexster" % "0.5.4"
// libraryDependencies += "com.tinkerpop.rexster" % "rexster-protocol" % "2.6.0"
// libraryDependencies += "com.github.scopt" %% "scopt" % "3.3.0"

// Resolves
resolvers += Resolver.sonatypeRepo("public")
