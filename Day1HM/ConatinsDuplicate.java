class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums) {
            if(set.contains(num)) {
                return true;   // Duplicate found
            }
            set.add(num);
        }
        
        return false;  // No duplicates found
    }
}
