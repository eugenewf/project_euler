/*largest palindrome product of three digit numbers*/
#include <math.h>
#include <stdio.h>
int isPalindrome(int value);

int main(){
	int i,j,max=0;

	for (i=999;i>99 && i*999>max;i--){
		for (j=999;j>=i && i*j>max;j--){
			if (isPalindrome(i*j)){
				max=i*j;
			}
		}
	}
	fprintf(stdout, "%d\n", max);
	return 0;
}

int isPalindrome(int value){
	int i, left, right, digits = (int)log10f((float)value);

	for (i=0; i<=digits/2; i++){
		left = (value%(int)powf(10.0f,(float)(digits+1-i)))/(int)powf(10.0f,(float)(digits-i));
		right = (value%(int)powf(10.0f,(float)(1+i)))/(int)powf(10.0f,(float)(i));
		if (left!=right){
			return 0;
		}
	}
	return 1;
}
