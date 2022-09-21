 #include <stdio.h>

int main()
{
	int test, student;
	int score[1000];
	scanf("%d", &test);

	for (int i = 0; i < test; i++)
	{
		int mean = 0;
		double cnt = 0;
		scanf("%d", &student);
		for (int j = 0; j < student; j++)
		{
			scanf("%d", &score[j]);
			mean = mean + score[j];
		}
		mean = mean / student;

		for (int k = 0; k < student; k++)
		{
			if (score[k] > mean)
			{
				cnt++;
			}
		}
		printf("%.3lf%%\n", cnt / student * 100);
	}
	return 0;
}