/**
 * COPYRIGHT (C) 2016 Vamsi. 
 * 
 * @author Vamsi Dharmavarapu
 */
package com.jda.codehub.CodeHubServices.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.joda.time.LocalDateTime;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.jda.codehub.controller.SubmissionsController;
import com.jda.codehub.services.facade.dto.entities.SubmissionsListDTO;
import com.jda.codehub.services.facade.dto.entities.SubmissionsSearchDTO;
import com.jda.codehub.services.facade.dto.interfaces.ISubmissionsService;

public class SubmissionsControllerTest extends AbstractControllerTest {
	
	@InjectMocks
	private SubmissionsController controller;
	
	@Mock
	private ISubmissionsService service;

	private MockMvc mockMvc;
	
	/**
	 * Sets the up.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	
	@Test
	@Ignore
	public void searchSubmissionsTest() throws Exception {
		SubmissionsListDTO listDTO = new SubmissionsListDTO();
		SubmissionsSearchDTO searchDTO = new SubmissionsSearchDTO();
		
		//JSONObject listJSON = "{"submissions":[{"id":12790016,"title":"573B - Bear and Blocks","metadata":{"level":"Hard","rating":3,"users_attempted":13548},"source":"#pragma warning(disable:4996)\n#include<iostream>\n#include<algorithm>\n#include<stdio.h>\n#include<cstring>\n#include<cmath>\n#include<utility>\n#include<queue>\n#include <vector>\n#include <set>\nusing namespace std;\n#define maxn 1000005\n#define inf 0xfffffff\n#define LL __int64\n#define mp make_pair\n#define pr pair<LL,LL>\nint a[maxn],b[maxn],c[maxn],d[maxn];\nint main(){\n int n;\n cin>>n;\n memset(c,0,sizeof c);\n memset(d,0,sizeof d);\n for (int i = 0; i < n; i++)\n {\n  scanf(\"%d\",&a[i]);\n }\n int top = 1;\n for (int i = 0;i<n;i++)\n {\n  if(a[i] >= top){\n   c[i] = top;\n   top++;\n  }else{\n   c[i] = a[i];\n   top = c[i]+1;\n  }\n }\n top = 1;\n for (int i = n-1;i>=0;i--)\n {\n  if(a[i] >= top){\n   d[i] = top;\n   top++;\n  }else{\n   d[i] = a[i];\n   top = d[i]+1;\n  }\n }\n int ans = 1;\n for (int i = 0;i<n;i++)\n  ans = max(ans,min(c[i],d[i]));\n printf(\"%d\\n\",ans);\n return 0;\n}","status":"Accepted","language":"GNU C++"},{"id":12857344,"title":"573B - Bear and Blocks","metadata":{"level":"Hard","rating":2,"users_attempted":10799},"source":"#include <bits/stdc++.h>\n// #include \"../../bits/stdc++.h\"\n\nusing namespace std;\n#define N 123456\nint a[N], le[N], ri[N];\n\nint main() {\n    int n;\n    scanf(\"%d\", &n);\n    for (int i = 0; i < n; ++i) {\n        scanf(\"%d\", a + i);\n    }\n    int o = 1;\n    for (int i = 0; i < n; ++i) {\n        o = min(o, a[i]);\n        le[i] = o++;\n    }\n    o = 1;\n    int ans;\n    for (int i = n - 1; i >= 0; --i) {\n        o = min(o, a[i]);\n        ri[i] = o++;\n        ans = max(ans, min(le[i], ri[i]));\n    }\n    printf(\"%d\\n\", ans);\n\n    return 0;\n}","status":"Wrong answer on test 1","language":"GNU C++11"},{"id":12798976,"title":"573B - Bear and Blocks","metadata":{"level":"Hard","rating":3,"users_attempted":14093},"source":"/* ***********************************************\nAuthor        :zyc\nCreated Time  :2015/9/1 16:16:11\nFile Name     :D.cpp\n************************************************ */\n\n#include <stdio.h>\n#include <string.h>\n#include <iostream>\n#include <algorithm>\n#include <vector>\n#include <queue>\n#include <set>\n#include <map>\n#include <cmath>\n#include <string>\n#include <math.h>\n#include <stdlib.h>\n#include <time.h>\n#include <cstring>\nusing namespace std;\n#define ll long long\n#define N 100100\nconst int inf=(1<<30);\nint num[N],nn[N];\nint main()\n{\n    //freopen(\"in.txt\",\"r\",stdin);\n    //freopen(\"out.txt\",\"w\",stdout);\n    int n;\n    scanf(\"%d\",&n);\n    scanf(\"%d\",&num[0]);\n    nn[0]=1;\n    int ans=0;\n    for(int i=1;i<n;i++)\n    {\n        scanf(\"%d\",&num[i]);\n        nn[i]=min(nn[i-1]+1,num[i]);\n    }\n    nn[n-1]=1;\n    for(int i=n-2;i>=0;i--)\n    {\n        nn[i]=min(nn[i],nn[i+1]+1);\n        ans=max(ans,nn[i]);\n    }\n    printf(\"%d\\n\",ans);\n    return 0;\n}","status":"Wrong answer on test 8","language":"GNU C++"},{"id":12760064,"title":"573B - Bear and Blocks","metadata":{"level":"Easy","rating":0,"users_attempted":8231},"source":"#include\"iostream\"\n#include\"cstring\"\n#include\"cmath\"\n#include\"cstdio\"\n#include\"algorithm\"\ntypedef long long ll;\nusing namespace std;\nll n;\nll a[1000005];\nll f[1000005];\nint main()\n{\n    ios_base::sync_with_stdio(0);\n    cin>>n;\n    for(ll i = 1;i<=n;i++)cin>>a[i];\n    f[1] = 1;\n    f[n] = 1;\n    ll res = 1;\n    ll cs = n/2;\n    if(n % 2 == 1)cs++;\n    for(ll i = 2;i<=cs;i++)\n    {\n        f[i] = min(a[i]-1,min(a[i+1],a[i-1])) + 1;\n        f[n-i+1] = min(a[n-i+1]-1,min(a[n-i+2],a[n-i])) + 1;\n        f[i] = min(f[i-1]+1,f[i]);\n        f[n-i+1] = min(f[n-i+2]+1,f[n-i+1]);\n        \n    }\n    for(ll i = 2;i<n;i++)\n    {\n        f[i] = min(f[i],min(f[i-1]+1,f[i+1]+1));\n        res = max(res,f[i]);\n    }\n    //for(ll i = 1;i<=n;i++)cout<<f[i]<<endl;\n    cout<<res;\n    return 0;\n}","status":"Wrong answer on test 15","language":"GNU C++"},{"id":12762368,"title":"573B - Bear and Blocks","metadata":{"level":"Medium","rating":3,"users_attempted":13756},"source":"#include <bits/stdc++.h>\n#define Nmax 1000005\n#define INF 2000000000\nusing namespace std;\nint n,a[Nmax],b[Nmax],dp[Nmax],L[Nmax],R[Nmax],st[Nmax];\ninline bool cmp(int x, int y)\n{\n    return a[x]<a[y];\n}\nint main()\n{\n    int i,j,sol=0,p,top=0;\n    cin.sync_with_stdio(0);\n    cin>>n;\n    for(i=1;i<=n;++i)\n    {\n        cin>>a[i];\n        dp[i]=INF;\n        b[i]=i;\n    }\n    for(i=1;i<=n;++i)\n    {\n        while(top && a[st[top]]>a[i])\n        R[st[top--]]=i;\n        st[++top]=i;\n    }\n    top=0;\n    for(i=n;i;--i)\n    {\n        while(top && a[st[top]]>a[i])\n        L[st[top--]]=i;\n        st[++top]=i;\n    }\n    dp[0]=INF;\n    dp[n+1]=INF;\n    a[0]=INF;\n    a[n+1]=INF;\n    sort(b+1,b+n+1,cmp);\n    for(int k=1;k<=n;++k)\n    {\n        i=b[k];\n        dp[i]=min(i,n-i+1);\n        dp[i]=min(dp[i],a[i]);\n        if(R[i]) \n        dp[i]=min(dp[i],dp[R[i]]+R[i]-i);\n        if(L[i])\n        dp[i]=min(dp[i],dp[L[i]]+i-L[i]);\n        sol=max(sol,dp[i]);\n    }\n    cout<<sol<<endl;\n}","status":"Accepted","language":"GNU C++"},{"id":12859649,"title":"573B - Bear and Blocks","metadata":{"level":"Easy","rating":5,"users_attempted":11437},"source":"#include <assert.h>\n#include <algorithm>\n#include <cmath>\n#include <deque>\n#include <iostream>\n#include <istream>\n#include <fstream>\n#include <sstream>\n#include <set>\n#include <vector>\n#include <queue>\n#include <string>\n#include <unordered_map>\n\ntypedef long long ll;\n\nusing namespace std;\n\nint main(){\n vector<ll> blocks;\n\n\n ll buf, n, total;\n cin >> n;\n for (int i = 0; i < n; i++){\n  cin >> buf;\n  blocks.push_back(buf);\n  total += buf;\n }\n\n ll ops, n_zero;\n n_zero = 0;\n ops = 0;\n\n while (n_zero < total){\n\n  vector<ll> new_blocks;\n\n  //remove the boundaries\n  n_zero += blocks[0];\n\n  for (int i = 1; i < blocks.size() - 1; i++){ //calculate removal for the inner blocks -> if 0, also remove\n   ll left = blocks[i - 1];\n   ll mid = blocks[i];\n   ll right = blocks[i + 1];\n\n   ll low = min(left, min(mid, right));\n\n   if (mid == 0){\n    new_blocks.push_back(0);\n   }\n   else if (mid == low){\n    new_blocks.push_back(mid - 1);\n    n_zero += 1;\n   }\n   else{\n    n_zero += mid - low;\n    new_blocks.push_back(low);\n   }\n\n  }\n  \n  n_zero += blocks[blocks.size() - 1];\n\n  blocks = new_blocks;\n\n  ops++;\n }\n\n cout << ops << endl;\n}","status":"Wrong answer on test 1","language":"GNU C++11"},{"id":12761345,"title":"573B - Bear and Blocks","metadata":{"level":"Hard","rating":2,"users_attempted":6872},"source":"#include <set>\n#include <map>\n#include <cstdio>\n#include <vector>\n#include <cassert>\n#include <iostream>\n#include <algorithm>\n\nusing namespace std;\n\nconst int N = 200000;\n\nint n, a[N], ans = 0;\nbool vis[N];\nset <int> s;\nset < pair <int, int> > t;\n\nint main() {\n\n    scanf(\"%d\", &n);\n\n    for (int i = 0; i < n; i++) {\n        scanf(\"%d\", &a[i]);\n        vis[i] = false;\n        s.insert(i);\n        t.insert(make_pair(a[i], i));\n    }\n\n    for (int i = 0;; i++) {\n        if (s.empty()) {\n            printf(\"%d\\n\", i);\n            exit(0);\n        }\n        vector <int> v;\n        set <int>::iterator it = s.begin();\n        v.push_back(*it);\n        vis[*it] = true;\n        it = s.end();\n        it--;\n        if (!vis[*it]) {\n            v.push_back(*it);\n        }\n        vis[*it] = true;\n        set < pair <int, int> >::iterator k = t.begin();\n        while (k != t.end() && (*k).first <= i + 1) {\n            int x = (*k).second;\n            if (!vis[x]) {\n                vis[x] = true;\n                v.push_back(x);\n            }\n            k++;\n        }\n        for (int j = 0; j < v.size(); j++) {\n            int x = v[j];\n            it = s.lower_bound(x);\n            it++;\n            if (it != s.end()) {\n                t.erase(make_pair(a[*it], *it));\n                a[*it] = 1;\n                t.insert(make_pair(a[*it], *it));\n            }\n            it--;\n            if (it != s.begin()) {\n                it--;\n                t.erase(make_pair(a[*it], *it));\n                a[*it] = 1;\n                t.insert(make_pair(a[*it], *it));\n            }\n        }\n        for (int j = 0; j < v.size(); j++) {\n            int x = v[j];\n            s.erase(x);\n            t.erase(make_pair(a[x], x));\n        }\n    }\n\n    return 0;\n\n}","status":"Accepted","language":"GNU C++11"},{"id":12764929,"title":"573B - Bear and Blocks","metadata":{"level":"Easy","rating":0,"users_attempted":14468},"source":"//Andrew Yang\n#include <iostream>\n#include <stdio.h>\n#include <sstream>\n#include <fstream>\n#include <string>\n#include <string.h>\n#include <vector>\n#include <deque>\n#include <queue>\n#include <stack>\n#include <set>\n#include <unordered_set>\n#include <map>\n#include <unordered_map>\n#include <algorithm>\n#include <functional>\n#include <utility>\n#include <bitset>\n#include <cmath>\n#include <cstdlib>\n#include <ctime>\n#include <cstdio>\n#include <climits>\nusing namespace std;\n#define FOR(index, start, end) for(int index = start; index < end; index++)\n#define RFOR(index, start, end) for(int index = start; index > end; index--)\n#define FOREACH(itr, b) for(auto itr = b.begin(); itr != b.end(); itr++)\n#define RFOREACH(itr, b) for(auto itr = b.rbegin(); itr != b.rend; itr++)\n#define INF 1000000000\n#define M 1000000007\ntypedef long long ll;\ntypedef pair<int, int> pii;\nint towers[100001];\nint ans[100001];\nint main()\n{\n    int n;\n    scanf(\"%d\", &n);\n    FOR(i, 0, n)\n    {\n        scanf(\"%d\", &towers[i]);\n    }\n    ans[0] = 1;\n    ans[n - 1] = 1;\n    FOR(i, 1, n - 1)\n    {\n        ans[i] = min(ans[i - 1] + 1, towers[i]);\n    }\n    int m = 1;\n    RFOR(i, n - 2, 0)\n    {\n        ans[i] = min(ans[i], ans[i + 1] + 1);\n        m = max(m, ans[i]);\n    }\n    cout << m << endl;\n}","status":"Accepted","language":"GNU C++11"},{"id":12770817,"title":"573B - Bear and Blocks","metadata":{"level":"Medium","rating":2,"users_attempted":16373},"source":"#include <stdio.h>\n#include <algorithm>\n#include <cstdlib>\n#include <cmath>\n#include <string.h>\n#include <iostream>\n#include <vector>\n#include <limits.h>\nusing namespace std;\n#define FOR(a,b) for(a=0;a<b;a++)\nint main(){\n  int n,i,prev,cov,ans=0,mini,sum=0;\n  scanf(\"%d\",&n);\n  int *a=new int[n+1];\n  FOR(i,n)\n    scanf(\"%d\",&a[i]);\n  a[n]=0;\n  while(1){\n    sum=0;\n    prev=0;\n    for(i=0;i<n;i++){\n      cov=0;\n      mini=min(prev,a[i+1]);\n      if(a[i]>1 && mini>0){\n          if(a[i]>mini)\n            cov=mini;\n          else if(a[i]==mini)\n            cov=mini-1;\n          else cov=a[i]-1;\n      }\n      prev=a[i];\n      a[i]=cov;\n      sum+=a[i];\n    }\n    ans++;\n    if(sum==0)\n      break;\n  }\n  printf(\"%d\\n\",ans);\n}","status":"Time limit exceeded on test 7","language":"GNU C++"},{"id":12836609,"title":"573B - Bear and Blocks","metadata":{"level":"Easy","rating":3,"users_attempted":7251},"source":"#include <bits/stdc++.h>\nusing namespace std;\n\n#define MAXN 100005\n#define INF 1<<30\n\nint N;\nint towers[MAXN];\nint* lst = new int[MAXN];\nint* rst = new int[MAXN];\n\nvoid update(int* st, int idx, int x, int lo=0, int hi=-1, int node=0) {\n if (hi == -1) {\n  hi = N - 1;\n }\n if (idx < lo || idx > hi) {\n  return;\n }\n if (lo == hi) {\n  st[node] = x;\n  return;\n }\n int mid = (lo + hi) / 2;\n update(st, idx, x, lo, mid, 2 * node + 1);\n update(st, idx, x, mid + 1, hi, 2 * node + 2);\n st[node] = min(st[2 * node + 1], st[2 * node + 2]);\n}\n\nint query(int* st, int a, int b, int lo=0, int hi=-1, int node=0) {\n if (hi == -1) {\n  hi = N - 1;\n }\n if (lo > b || hi < a) {\n  return INF;\n }\n if (lo >= a && hi <= b) {\n  return st[node];\n }\n int mid = (lo + hi) / 2;\n return min(query(st, a, b, lo, mid, 2 * node + 1),\n   query(st, a, b, mid + 1, hi, 2 * node + 2));\n}\n\nint main() {\n ios_base::sync_with_stdio(false);\n cin.tie(0);\n\n cin >> N;\n for (int i = 0; i < N; i++) {\n  cin >> towers[i];\n  update(lst, i, towers[i] - i);\n  update(rst, i, towers[i] + i);\n }\n\n int ans = 0;\n for (int i = 0; i < N; i++) {\n  int b = min(query(lst, 0, i) + i, query(rst, i, N - 1) - i);\n  b = min(b, min(i + 1, N - i));\n  ans = max(ans, b);\n }\n \n cout << ans << endl;\n return 0;\n}","status":"Runtime error on test 7","language":"GNU C++11"}],"count":67318,"pageCount":10,"errorCode":null}";
		
		
		mockMvc.perform(
				get("/submissions/list/1")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)).andDo(log())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
				//.andExpect(content().json());
		
	}

}
