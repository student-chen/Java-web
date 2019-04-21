function over_change(src)
{
  if (!src.contains(event.fromElement))
  {
    src.style.cursor="hand";
  }
}

function out_change(src)
{
  if (!src.contains(event.toElement))
  {
    src.style.cursor = "default";
  }
}