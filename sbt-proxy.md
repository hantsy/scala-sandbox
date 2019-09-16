# Configure a proxy repository

 Follow [the steps]( https://www.scala-sbt.org/1.0/docs/Proxy-Repositories.html) provided in Sbt docs, configure a local Maven proxy repository to speed up the dependency resolving. 

1. Create  a `~/.sbt/repositories` file. 

   ```
   [repositories]
     local
     maven-local
     nexus-maven-proxy: <local Nexus repos url>
     nexus-ivy-proxy: <local Nexus repos url> 
   ```

2. If you have set securities for this server.  Create a `~/.ivy2/.credentials` file to store user/password for the server.

   ```
   realm=Sonatype Nexus Repository Manager
   host=<domain of Nexus server>
   user=<username>
   password=<passsword>
   ```

   For the latest sbt 1.x, the configuration is done. 

   If the credentials setting does not work,  try to add the following parameters to your command line. 

   ```bash
   -Dsbt.boot.credentials=$HOME/.ivy2/.credentials
   ```

   Or add the following settings in sbt project configuration.

   ```scala
   credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
   ```

   

Additionally, sbt launcher supports two parameters.

- `sbt.override.build.repos`

  eg. `-Dsbt.override.build.repos=true` to use the properly configured
  `~/.sbt/repositories` file leads to only your proxy repository used for
  builds

- `sbt.repository.config`

  eg. `-Dsbt.repository.config=<path-to-your-repo-file>` to specify the repository to be used.