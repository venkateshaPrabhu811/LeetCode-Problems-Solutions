Approach 1 :
Using Stack
add -1 to indicate end of previous valid strings
By pushing the close paranthesis when stack is empty we can indicate the end of the previous valid string
And by popping everytime we calculate the length of the valid string by taking peek of the stack
​
Approach 2:O(1) space
​
by calculation the number of open and close paranthesis from both sides , whenever the open and close parenthesis are equal we find the len by adding both
From left to right when close > open that is invalid so we reset the value;
From right to left when open > close we reset open and close
​
Approach 3 : Using dp
the open paranthesis does not affect the answer
when we encounter a close paranthesis we check whether the previous character is open paranthesis if so we check the length of the previously validated string
else  when we encounter a close paranthesis again we check the length of that valid strings and go before the validated string and check whether there is a open paranthesis else it is invalid
​