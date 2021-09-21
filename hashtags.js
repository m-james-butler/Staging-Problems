function getTags(str) {
  let arr = str.replace(/,/g, "").split(" ");
  
  arr.sort((fw, sw) => sw.length - fw.length);
  
  let tags = [];
  
  if (arr.length > 3) {
    tags = arr.slice(0,3);
  } else {
    tags = arr;
  }
  
  for (let i = 0; i < tags.length; i++) {
    tags[i] = '#' + tags[i].toLowerCase();
  }
  
  return tags.join(", ");
}

console.log(getTags("Hey, Liara, you ever find dinosaurs while you're digging around"));
