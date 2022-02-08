# Requirements

#### Post has 4 state:

1. Published
- Post was published and All users can see this post 
2. Draft
- Post unfinished. 
- Only user that create this post can see it
- User can publish this post
3. Removed
- Post was softly removed
- Only owner can see (In TRASH folder)

User can delay publishing of the post 

## TODO

1. Refactoring service for delay publishing
2. Add auth
3. Made decision about how to store Post body( in html, in markdown or both)
4. Same for comment(about 3 step)
5. Add resource storage for images



## User stories


### Create Post

User want to create post
He clicks on button "Create Post"
Add post content:
- headline
- text
Next he clicks on button "Publish Post"
And see published post

#### Add tags to post:
User find interesting tags and add to post
If needed tag not exists he can add new by clicking on button "Add tag"
Next write tag and click on button "Save Tag"


### Delay post publishing

After writing post
User can clicks on button "publish post at "
choose date:
10:00
10:30
and so on
and click on button "publish"



### Click on tag

If user click on tag will be see list of posts that have this tag


Need implement search by tags, post text, headline, users
Also sorts by date














