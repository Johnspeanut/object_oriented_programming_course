#  Brief Summary

#### Developers: Wenxin Yang, Yaqian Liu, and Qiong Peng.

## 1. Run the package
Please run the main class within the view subpackage.
If there is an error popping up, please edit the configurations and fill the parameter box with command line.

We did a few experiments and checked if this package can take care of various combinations of command line arguments. 
### Case 1:
The command line requests the package to add a new todo, update the completed status, and display at the same time.
``` bash
$ --csv-file todos.csv --add-todo --todo-text needFinishedInTwoDays --completed --due 3/20/2021 --complete-todo 1 --priority 1 --category emergency --show-incomplete --display --sort-by-priority
```
### Case 2:
Other than adding a new todo and updating completed status, this command line asks the package to display todo list sorted by date and priority at the same time.
The package will reminder us that sort-by-date is conflicted with sort-by-priority
``` bash
$ --csv-file todos.csv --add-todo --todo-text needFinishedInTwoDays --completed --due 3/20/2021 --complete-todo 1 --priority 1 --category emergency --show-incomplete --display --sort-by-priority --sort-by-date
```
### Case 3:
This command line does not provide required argument. It will pop up a reminder, which says it needs an argument.
``` bash
$ --add-todo --todo-text needFinishedInTwoDays --completed --due 3/20/2021 --complete-todo 1 --priority 1 --category emergency --show-incomplete --display --sort-by-priority
```
We also tested other cases. Overall, this package looks versatile.

## 2. Some thoughts
##### 2.1 We applied builder pattern in creating Todo class and Option class. 
##### 2.2 We break the package into three subpackages and try to decouple these three subpackages.
##### 2.3 We tried to follow the OOD principles and let each part of the package extensive friendly.
