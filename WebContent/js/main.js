function validateSearch (searchForm) {
  if (searchForm.searchQuery.value.trim() === '') {
    searchForm.searchQuery.focus()
    searchForm.searchQuery.style.borderColor = 'red'
  } else {
    searchForm.submit()
  }
}
