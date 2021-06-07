#!/bin/bash
function read_file(){
    cat $1 | while read line
      do
        if [[ $line == table* && ! $line =~ "." ]]
        then
           echo $line
        fi
      done
}
function ergodic(){
    for file in ` ls $1 `
    do
        if [ -d $1"/"$file ]
        then
             ergodic $1"/"$file
        else
             read_file $1"/"$file
        fi
    done
}
INIT_PATH="/Users/zhangjiale/IdeaProjects/kuaishou_workspace/kuaishou-airflow-abtest/dags/app_analytics_core/function_analysis/bitmap"
ergodic $INIT_PATH