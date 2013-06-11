/*sum of even Fibonnaci numbers less than four million*/

#include <stdio.h>

int main(){
	int n=1,n1=0,n2=0,sum=0;

	while(n<4000000){/*four million*/
fprintf(stderr, "%d\n", n);
		if(n%2==0){
			sum+=n;
		}
		n2=n1;
		n1=n;
		n=n2+n1;
	}
	
	fprintf(stdout, "%d\n", sum);
	return 0;
}
