select
	concat(
    '<articles>',
    group_concat('<article> <id>', id, '</id> <title>', title, '</title> <body>', body,'</body> </article />'
    separator ''),
    '</articles>') as xmldoc
    from articles order by id