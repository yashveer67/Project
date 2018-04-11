import java.util.Scanner;
class Longtime
{
	int pid,arv=2,cpu,leftcpu;
	Longtime(int pid,int cpu){
		this.pid=pid;
		this.cpu=cpu;
	}
	Longtime(){}
	public static void main(String[] argu){
		Scanner input=new Scanner(System.in);
		Longtime[] lt=new Longtime[50];
		int total=0,pno,i,j,wait=0,turnaround=0;
		System.out.print("\nEnter No of Processes : ");
		pno=input.nextInt();
		for(i=0;i<pno;i++){
			int pid,cpu;
			System.out.print("Enter Process id and CPU time ");
			pid=input.nextInt();
			cpu=input.nextInt();
			lt[i]=new Longtime(pid,cpu);
			total=total+cpu;
		}
		for(i=0;i<pno-1;i++){
                        for(j=i+1;j<pno;j++){
				if(lt[i].cpu<lt[j].cpu){
                                        Longtime temp=new Longtime();
                                        temp=lt[i];
                                        lt[i]=lt[j];
                        	        lt[j]=temp;
				}
                        }
                }
		for(i=0;i<pno-1;i++){
                        for(j=i+1;j<pno;j++){
                                if(lt[i].cpu==lt[j].cpu){
                                        if(lt[i].pid<lt[j].cpu){
                                        Longtime temp=new Longtime();
                                        temp=lt[i];
                                        lt[i]=lt[j];
                                        lt[j]=temp;
                                        }
                                }
                        }
                }
		j=0;
		System.out.println("\n###Gannt Chart###\n");
		for(int t=1;t<=total;t++){
			if(t>=2){
				t=t+lt[j].cpu-1;
				lt[j].leftcpu=t;
				System.out.print("\n At time "+(t-lt[j].cpu)+" to "+t+"  |   P"+lt[j].pid+"is Running");
				j++;
			}
			else{
				System.out.print("\n At time 0 to 2  |  No process Running");
        			total++;
        			t++;
			}
		}
		for(i=0;i<pno;i++){
			System.out.print("\nTurn Around time for P"+lt[i].pid+" is : "+(lt[i].leftcpu-2));
			System.out.print("	Waiting time for P"+lt[i].pid+" is : "+(lt[i].leftcpu-lt[i].cpu-2));
			wait=wait+lt[i].leftcpu-lt[i].cpu-2;
			turnaround=turnaround+lt[i].leftcpu-2;
		}
		wait=wait/pno;
		turnaround=turnaround/pno;
		System.out.print("\n\nAvarage Turn Around time : "+turnaround);
		System.out.print("\n\nAvarage waiting time : "+wait);
	}
}
