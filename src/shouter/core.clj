(ns shouter.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(require '[clojure.java.jdbc :as sql])

(def db-connection "postgres://localhost:5432/shouter")

(sql/db-do-commands db-connection (sql/create-table-ddl :testing [[:data :text]]))

(sql/insert! db-connection :testing {:data "Hello World 2"})

(sql/query db-connection ["select * from testing"])

(sql/db-do-commands db-connection "drop table testing")
