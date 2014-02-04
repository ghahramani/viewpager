/* C++ code produced by gperf version 3.0.3 */
/* Command-line: /Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/gperf -L C++ -E -t /private/var/folders/zs/2vsy8lqj1hzckz7rhwprb5wh0000gp/T/ralcocer/tabs-generated/KrollGeneratedBindings.gperf  */
/* Computed positions: -k'' */

#line 3 "/private/var/folders/zs/2vsy8lqj1hzckz7rhwprb5wh0000gp/T/ralcocer/tabs-generated/KrollGeneratedBindings.gperf"


#include <string.h>
#include <v8.h>
#include <KrollBindings.h>

#include "com.navid.tabs.PagerTabsModule.h"
#include "com.navid.tabs.PagerTabsProxy.h"


#line 14 "/private/var/folders/zs/2vsy8lqj1hzckz7rhwprb5wh0000gp/T/ralcocer/tabs-generated/KrollGeneratedBindings.gperf"
struct titanium::bindings::BindEntry;
/* maximum key range = 2, duplicates = 0 */

class TabsBindings
{
private:
  static inline unsigned int hash (const char *str, unsigned int len);
public:
  static struct titanium::bindings::BindEntry *lookupGeneratedInit (const char *str, unsigned int len);
};

inline /*ARGSUSED*/
unsigned int
TabsBindings::hash (register const char *str, register unsigned int len)
{
  return len;
}

struct titanium::bindings::BindEntry *
TabsBindings::lookupGeneratedInit (register const char *str, register unsigned int len)
{
  enum
    {
      TOTAL_KEYWORDS = 2,
      MIN_WORD_LENGTH = 29,
      MAX_WORD_LENGTH = 30,
      MIN_HASH_VALUE = 29,
      MAX_HASH_VALUE = 30
    };

  static struct titanium::bindings::BindEntry wordlist[] =
    {
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""},
#line 17 "/private/var/folders/zs/2vsy8lqj1hzckz7rhwprb5wh0000gp/T/ralcocer/tabs-generated/KrollGeneratedBindings.gperf"
      {"com.navid.tabs.PagerTabsProxy", ::com::navid::tabs::tabs::PagerTabsProxy::bindProxy, ::com::navid::tabs::tabs::PagerTabsProxy::dispose},
#line 16 "/private/var/folders/zs/2vsy8lqj1hzckz7rhwprb5wh0000gp/T/ralcocer/tabs-generated/KrollGeneratedBindings.gperf"
      {"com.navid.tabs.PagerTabsModule", ::com::navid::tabs::PagerTabsModule::bindProxy, ::com::navid::tabs::PagerTabsModule::dispose}
    };

  if (len <= MAX_WORD_LENGTH && len >= MIN_WORD_LENGTH)
    {
      register int key = hash (str, len);

      if (key <= MAX_HASH_VALUE && key >= 0)
        {
          register const char *s = wordlist[key].name;

          if (*str == *s && !strcmp (str + 1, s + 1))
            return &wordlist[key];
        }
    }
  return 0;
}
#line 18 "/private/var/folders/zs/2vsy8lqj1hzckz7rhwprb5wh0000gp/T/ralcocer/tabs-generated/KrollGeneratedBindings.gperf"

