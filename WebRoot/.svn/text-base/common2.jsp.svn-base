<div class="sidebar-menu toggle-others">
<div class="sidebar-menu-inner">	
				
				<header class="logo-env">
					
					<!-- logo -->
					<div class="logo">
						<a href="javascript:to('ToLogin.action');" class="logo-expanded">
							<img src="assets/images/logo3.png" width="160" alt="" />
						</a>
					</div>
					
					<!-- This will toggle the mobile menu and will be visible only on mobile devices -->
					
						
				</header>
						
				
						
				<ul id="main-menu" class="main-menu">
					<li class="active opened active">
						<span class="title" style="color:white">${role.desc}</span>						
						<ul>
						   <c:if test="${status2==2 }">
					       <c:forEach items="${menuList1}" var="right1" varStatus="status">       
					          <li class="active" style="height:40px;">     
								<a href="javascript:to('${right1.righturl}');">
									<span class="title">${right1.righttext}</span>
								 </a>
							  </li>
					          <div id="count" style="margin-top: -46px; margin-left: 26px;">
						        <a data-toggle="dropdown" style="margin-left: 84px;"/>
							     <i class="fa-bell-o"></i>
							     <span class="badge badge-purple" style="right:16px;padding-right: 8px;top: -5px">${total}</span>
						      </a>		
			               </div>
			               </c:forEach>
			               <li><li>
			               </c:if>
			              <c:if test="${status1==1 }">
						   <c:forEach items="${menuList}" var="right" varStatus="status">       
					          <li class="active" style="height:40px;">
								<a href="javascript:to('${right.righturl}');">
									<span class="title">${right.righttext}</span>
								</a>
							  </li>
					       </c:forEach>
					       </c:if>
						</ul>
					</li>
				</ul>
				
			</div>
			</div>
			
		