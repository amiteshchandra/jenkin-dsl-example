def DSLs = [
        "mySampleDsl":
                [
                    'path': 'jobs/mysampleDsl.groovy'
                ]
]

DSLs.each { name, DSL ->

    def jobname = "dsl-" + name

    freeStyleJob(jobname) {

    
        triggers {
            githubPush()
        }

     
        scm {
            git {
                extensions { cleanBeforeCheckout() }
                remote {
                    url('git@github.com:amiteshchandra/jenkin-dsl-example.git')
                    branch('*/master')
                    
                }
            }
        }

        steps {
            dsl {
                external(DSL.path)
                removeAction('DELETE')
                removeViewAction('IGNORE')
            }
        }
    }
}