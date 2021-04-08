(ns shouter.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(require '[clojure.java.jdbc :as sql])

(sql/db-do-commands "postgresql://localhost:5432/shouter"
                    (sql/create-table-ddl :testing [[:data :text]]))

(sql/insert! "postgresql://localhost:5432/shouter"
                    :testing {:data "Hello World 2"})


(sql/query "postgresql://localhost:5432/shouter"
                  ["select * from testing"])

(sql/db-do-commands "postgresql://localhost:5432/shouter"
                           "drop table testing")
