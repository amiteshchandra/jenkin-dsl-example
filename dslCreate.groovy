job('DSL-Using-Script-1-Test') {
    scm {
        git('https://github.com/amiteshchandra/SimpleWebApp.git')
    }
    triggers {
        scm('H/15 * * * *')
    }
    steps {
        maven('-e clean test')
    }
}