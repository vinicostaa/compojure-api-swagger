(defproject account-service "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [metosin/compojure-api "1.1.11"]]
  :ring {:handler account-service.core/app}
  :profiles {:dev
             {:plugins [[lein-ring "0.12.5"]]}
             :dependencies [[javax.servlet/servlet-api "2.5"]]})