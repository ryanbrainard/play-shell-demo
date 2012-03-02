Play Shell Demo
===============

When developing and managing an application, it can sometimes be helpful to be able to execute commands within the
context of the live application. This could be used for testing application behavior or working with the models and database.
Similar to `rails console` in Ruby, the [`play-shell` module](https://github.com/grandfatha/play-shell),
can launch a Play! application within an interactive `groovysh` shell. Combined with Heroku's ability to run one-off processes,
running `heroku run play shell` launches a new dyno and starts up a `groovysh` console in the context of the application.

Setup
-----
This demo application has already been configured with the `play-shell` module, but to follow these steps to add it to your own application:

1. Add the `play-shell` module as a Git submodule in your project
`git submodule add git://github.com/grandfatha/play-shell.git vendor/play-shell`

2. Update your `dependecies.yml`


    require:
        - play
        - play-shell -> play-shell

    repositories:
        - vendored-modules:
            type: local
            artifact: ${application.path}/vendor/[module]
            contains:
                - play-shell


3. Run `play dependecies` to install the module.


heroku run play shell
---------------------
After pushing the changes to Heroku, run `heroku run play shell` to launch the `groovysh` shell.

In the example below, a new `Post` is created. Once the transaction is commited, the new Post can be viewed in the web application.

    => heroku run play shell
    Running play shell attached to terminal... up, run.1
    ~        _            _
    ~  _ __ | | __ _ _  _| |
    ~ | '_ \| |/ _' | || |_|
    ~ |  __/|_|\____|\__ (_)
    ~ |_|            |__/
    ~
    ~ play! 1.2.4, http://www.playframework.org
    ~
    06:21:41,747 INFO  ~ Starting /app
    06:21:41,750 INFO  ~ Module play is available (/app/modules/play-shell)
    06:21:41,750 INFO  ~ Module crud is available (/app/modules/crud)
    06:21:41,803 WARN  ~ You're running Play! in DEV mode
    06:21:45,691 INFO  ~ Connected to jdbc:postgresql://ec2-107-22-213-155.compute-1.amazonaws.com/spulcjssme
    06:21:46,598 INFO  ~ Application 'play-shell-demo' is now started !
    Mar 2, 2012 6:21:47 AM java.util.prefs.FileSystemPreferences$2 run
    INFO: Created user preferences directory.
    Groovy Shell (1.7.10, JVM: 1.6.0_20)
    Type 'help' or '\h' for help.
    -------------------------------------------------------------------------------
    groovy:000> p = new Post()
    ===> null
    groovy:000> p.title = "A Post from Play Shell"
    ===> A Post from Play Shell
    groovy:000> p.body = "Is this really going to work?"
    ===> Is this really going to work?
    groovy:000> p.save()
    ===> A Post from Play Shell
    groovy:000> JPA.em().getTransaction().commit()
    ===> null
    groovy:000> exit