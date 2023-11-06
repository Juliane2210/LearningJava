/* *
 * Use static array for NewsFeed
 * with constant MAX_SIZE
 * */

public class NewsFeed {

	private Post[] messages;
	private int size;
	public static final int MAX_SIZE = 25;

	public NewsFeed() {
		this.messages = new Post[MAX_SIZE];
		this.size = 0;

		// Your code here.
	}

	public void add(Post message) {

		if (size < MAX_SIZE) {
			this.messages[size] = message;
			size += 1;
		}
	}

	public Post get(int index) {
		return messages[index];
	}

	public int size() {
		return size;
	}

	public void sort() {
		int i, j, argMin;
		Post tmp;
		for (i = 0; i < size - 1; i++) {
			argMin = i;
			for (j = i + 1; j < size(); j++) {
				if (messages[j].compareTo(messages[argMin]) < 0) {
					argMin = j;
				}
			}

			tmp = messages[argMin];
			messages[argMin] = messages[i];
			messages[i] = tmp;
		}

	}

	public NewsFeed getPhotoPost() {
		NewsFeed photoPostNewsFeeds = new NewsFeed();
		for (int i = 0; i < size; i++) {
			if (messages[i] instanceof PhotoPost) {
				photoPostNewsFeeds.add(messages[i]);
			}

		}
		return photoPostNewsFeeds;

	}

	public NewsFeed plus(NewsFeed other) {

		NewsFeed combinedNewsFeeds = new NewsFeed();

		// Add posts from initial NewsFeed
		for (int i = 0; i < size; i++) {
			combinedNewsFeeds.add(messages[i]);
		}

		// Add posts from the other NewsFeed
		for (int i = 0; i < other.size(); i++) {
			combinedNewsFeeds.add(other.get(i));
		}
		// sort posts
		combinedNewsFeeds.sort();
		return combinedNewsFeeds;
		// combinedNewsFeeds.size = this.size + other.size;
		// combinedNewsFeeds.messages = this.messages;

		// for (int j = 1; j < other.size - 1; j++) {
		// combinedNewsFeeds.messages[this.size + j] = other.messages[j];
		// }

		// combinedNewsFeeds.sort();

		// return combinedNewsFeeds;
	}

}
