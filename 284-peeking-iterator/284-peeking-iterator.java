// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iter;
    Integer next = null;
	public PeekingIterator(Iterator<Integer> iterator) {
	    iter = iterator;
        if(hasNext()) next = iter.next();
	}
	
	public Integer peek() {
        return next;
	}
	
	@Override
	public Integer next() {
	    Integer currval = next;
        if(iter.hasNext()){
            next = iter.next();
        }
        else{
            next = null;
        }
        return currval;
	}
	
	@Override
	public boolean hasNext() {
	    return next!=null || iter.hasNext();
	}
}