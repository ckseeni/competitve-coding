def check(x):
	global str2
	f=0
	if str2:
		for i in str2:
			if x==i:
				f=1
		if f==0:
			str2+=x	
		else:
			str2=str2+" "
	else:
		str2=x
str1=raw_input("\nEnter str1:")
str2=[]
for i in str1:
	check(i)
print str2
