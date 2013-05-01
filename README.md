Test app for Java Servlets & Torquebox integration
===================================================
[The documentation](http://torquebox.org/documentation/2.3.0/deployment-descriptors.html#webinf-web-xml) states that any (J)Ruby webapp can be extended by additional Java components outside Rack itself, such as plain Servlets or ServletFilters. This is a minimal application that aims to prove that.

### Note
The JAR is aready in place at `vendor/jars/`. Its source code is extremely simple and can be found under the `src.java/` directory. The whole building process is managed by Maven 3, in case you're interested in tweaking the source.

Installation steps (Linux/OS X)
--------------------------------
Please follow the order strictly so that the bug can be replicated. Do not clone the project until necessary.

1. Make sure `JAVA_HOME` is set
2. Set up rbenv. Please follow [the instructions](https://github.com/sstephenson/rbenv/). Additionally, you'll need the a couple of rbenv plugins: [rbenv-vars](https://github.com/sstephenson/rbenv-vars) and [ruby-build](https://github.com/sstephenson/ruby-build).
3. Once rbenv and its plugins are installed and loaded, install jruby-1.7.2 with this command: `rbenv install jruby-1.7.2`. Then, execute: `rbenv rehash` so the new binaries are into the `PATH`.
4. Clone this project and `cd` to the newly created directory.
5. Install the Bundler gem: `gem install bundler`
6. Install Torquebox 2.3.0: `gem install torquebox-server`
7. `rbenv rehash` again
8. Make sure `torquebox env` is correctly set. These variables are not declared by any dotfile:
  > `TORQUEBOX_HOME=$HOME/.rbenv/versions/jruby-1.7.2/lib/ruby/gems/shared/gems/torquebox-server-2.3.0-java`
  > `JBOSS_HOME=$HOME/.rbenv/versions/jruby-1.7.2/lib/ruby/gems/shared/gems/torquebox-server-2.3.0-java/jboss`
  > `JRUBY_HOME=$HOME/.rbenv/versions/jruby-1.7.2`
9. Now `bundle install`
10. Then, make sure you are at the application root directory and execute `torquebox deploy`
11. Start up Torquebox with `torquebox run`
12. Open any browser and go to [http://localhost:8080](http://localhost:8080). This request should be handled by the `torquebox.rack` filter.
13. And finally, the (potential) bug: change the URL and point to [http://localhost:8080/servlet](http://localhost:8080/servlet). This route should be managed by `HelloWorldServlet`, but a Sinatra 404 page is displayed instead.

### Additional info
+ The logs don't show any useful information regarding this behaviour. Interestingly enough, the logs that are produced during the `init()` and `destroy()` Servlet lifecycle events are not shown in the console either.
+ If I remove everything below `vendor/jars/` and then start the app server again, Torquebox would complain about missing classes, which makes sense.
+ Torquebox Server gem, version 2.3.0
+ Platform: OS X 10.8.3
+ `jruby 1.7.2 (1.9.3p327) 2013-01-04 302c706 on Java HotSpot(TM) 64-Bit Server VM 1.7.0_17-b02 [darwin-x86_64]`
+ `Java version "1.7.0_17"
  Java(TM) SE Runtime Environment (build 1.7.0_17-b02)
  Java HotSpot(TM) 64-Bit Server VM (build 23.7-b01, mixed mode)`
