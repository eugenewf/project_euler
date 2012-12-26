/*sum of multiples of 3 and 5 less than 1000*/

#include <stdio.h>

int main(){

	int multiples[1000];
	int base[] = {3,5};
	int i,j;

	for (i=0;i<1000;i++){
		multiples[i]=0;
	}

	for (i=0;i<2;i++){
		for (j=0;j<1000;j+=base[i]){
			multiples[j]=1;
		}
	}

	j=0;
	for (i=0;i<1000;i++){
		j+=(i*multiples[i]);
	}

	fprintf(stdout, "%d\n", j);
	return 0;
}
