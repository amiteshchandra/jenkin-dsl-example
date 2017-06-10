job('DSL-Using-Script-2-Test') {
    scm {
        git('https://github.com/amiteshchandra/SimpleWebApp.git')
    }
    triggers {
         githubPush()
    }
    steps {
        maven('-e clean test')
    }
}