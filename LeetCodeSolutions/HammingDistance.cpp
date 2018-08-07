#include<iostream>

/*
Hamming Distance is the distance between different bits of a particular number.
*/
const int hammingDistance(const int num1,const int num2)
{
  int result = (num1^num2);
  int count = 0;
   while (result) {
     result = result & (result-1);
     count++;
   }
  return count;
}
