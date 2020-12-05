<h1>Grade Sheet</h1>
<h2>All members: Chris Meyer, Cheveaux Beasley, John Summers(see note)</h2>
<ul><li>Proper use of online Scrum tools (scrumy.com) and online source code repository (github.com) _10/10</li>
<li>Code well commented.   Methods have Javadoc listing general purpose, params, and returns.  Individual lines are commented, where appropriate.  _10/10</li>
<li>Followed up on specific code review comments _10/10</li>
<li>List of at least three code review comments and corrections made:
<ul>
<li>______Implemented ci/cd__________________________</li>
<li>______changed typos in json__________________________</li>
<li>______re-implemented maven__________________________</li>
</ul>
</li>
<li>Written with Behavior Driven Design style unit tests.  These unit tests pass when run.  _10/10</li>
<li>Code in good form.  Uses standard Java naming conventions.  Good use of packages, datatypes, etc.  Proper exception handling.  Exceptions are handled appropriately, and are thrown up to the UI layer when needed.  No empty catch blocks. _5/10</li>
<li>Program works properly when deployed on Sandbox.  __10/10
</ul>

 

<h2>UI Specialist</h2> 

* Use both simple and advanced UI controls.   Good use of layouts and templates.  Layout makes sense, is fluid, is viewable.  _5/10

* Use Spring Boot controller to handle endpoint requests.  _10/10

* Business logic is not in view, and view logic is not in other layers.  _10/10

 * Consume another team's REST service/JSON feed.

<h2>Business Logic and Persistence Specialist</h2> 

* Provides an interface with both a Stub and Live implementation of that interface.  __10/10

* Interaction with either MySQL, filesystem, or both.  Can insert, update, and delete data. __5/10

* Provide an endpoint for another team to consume.  __5/10

* Business logic and persistence layers are as clean as possible.  Avoid view logic in these layers.  Use general Java packages whenever possible.   __10/10

 

<h2>Product Owner/Scrum Master/DevOps/GitHub Administrator</h2> 

This person coordinates the highest value features for the team, takes the lead in the design document, and adds collaborators to the GitHub project.

* Make initial commit to GitHub.  Manage github.com Feature Branches.  Add code reviewers as collaborators.  Assist team members with merge issues.  __10/10

* Performs Product Owner tasks: create stories, determine which projects and milestones  should be delivered this sprint. __10/10

* Performs Scrum Master Tasks: coordinate sprint planning meeting,  weekly standup meeting, sprint review and retrospective.  _5/10

* Implement CI/CD pipeline.  _10/10

<b>Note:</b> we lost John Summers to a death in his family very late in the semester, He was our Business logic and persistence specialist.
