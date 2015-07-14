import AssemblyKeys._

net.virtualvoid.sbt.graph.Plugin.graphSettings
assemblySettings

name := "huehuecoyotl"
version := "0.0.0"
scalaVersion := "2.11.1"

seq(assemblySettings: _*)

libraryDependencies ++= Seq(
  "log4j" % "log4j" % "1.2.15" excludeAll(
    ExclusionRule(organization = "com.sun.jdmk"),
    ExclusionRule(organization = "com.sun.jmx"),
    ExclusionRule(organization = "javax.jms"),
    ExclusionRule(organization = "commons-beanutils")
  ),
  "com.thinkaurelius.titan" % "titan-core" % "0.5.4"
    exclude("javax.jms", "jms")
    exclude("com.sun.jdmk", "jmxtools")
    exclude("com.sun.jmx", "jmxri")
    exclude("org.slf4j", "slf4j-simple")
    excludeAll(
      ExclusionRule(organization = "common-bean-utils")
    ),
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
)

test in assembly := {}
mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
{
  case PathList("javax", "servlet", xs @ _*) => MergeStrategy.last
  case PathList("javax", "activation", xs @ _*) => MergeStrategy.last
  case PathList("org", "apache", xs @ _*) => MergeStrategy.last
  case PathList("com", "google", xs @ _*) => MergeStrategy.last
  case PathList("com", "esotericsoftware", xs @ _*) => MergeStrategy.last
  case PathList("com", "codahale", xs @ _*) => MergeStrategy.last
  case PathList("com", "yammer", xs @ _*) => MergeStrategy.last
  case "about.html" => MergeStrategy.rename
  case "META-INF/ECLIPSEF.RSA" => MergeStrategy.last
  case "META-INF/mailcap" => MergeStrategy.last
  case "META-INF/mimetypes.default" => MergeStrategy.last
  case "plugin.properties" => MergeStrategy.last
  case "log4j.properties" => MergeStrategy.last
  case "overview.html" => MergeStrategy.rename
  case x => old(x)
}
}

// Maybe we don't need these
// libraryDependencies += "com.thinkaurelius.titan" % "titan-rexster" % "0.5.4"
// libraryDependencies += "com.tinkerpop.rexster" % "rexster-protocol" % "2.6.0"
// libraryDependencies += "com.github.scopt" %% "scopt" % "3.3.0"

// Resolves
resolvers += Resolver.sonatypeRepo("public")

//lazy val app = (project in file("app")).
//settings(commonSettings: _*).
// settings(
  // your settings here
// )

