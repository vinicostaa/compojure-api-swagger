(ns account-service.core
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [schema.core :as s]
            [ring.swagger.schema :as rs]))

(s/defschema Account
  {:id      Long
   :balance s/Num})

(s/defschema NewAccount (dissoc Account :id))

(s/defschema Transfer
  {:id           Long
   :from-account s/Int
   :to-account   s/Int
   :amount       s/Num
   :status       s/Keyword})

(s/defschema NewTransfer (dissoc Transfer :id :status))

(def app
  (api
   {:swagger
    {:ui   "/"
     :spec "/swagger.json"
     :data {:info {:title "Account Service"}
            :tags [{:name "api"}]}}}
   (context "/api" [] 
     :tags ["api"]
     (POST "/account" []
       :body [account (describe NewAccount "new account")]
       (ok))
     (POST "/transfer" []
       :body [transfer (describe NewTransfer "new transfer")]
       (ok)))))
